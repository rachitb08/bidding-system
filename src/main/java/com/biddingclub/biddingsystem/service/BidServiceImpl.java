package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.constants.EnumBidStatus;
import com.biddingclub.biddingsystem.constants.EnumMessage;
import com.biddingclub.biddingsystem.entity.Bid;
import com.biddingclub.biddingsystem.entity.Bidder;
import com.biddingclub.biddingsystem.entity.Item;
import com.biddingclub.biddingsystem.exception.BiddingException;
import com.biddingclub.biddingsystem.repository.BidRepository;
import com.biddingclub.biddingsystem.request.PlaceBidRequest;
import com.biddingclub.biddingsystem.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    ItemService itemService;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    BidderService bidderService;

    @Override
    @Transactional
    public ApiResponse placeBid(PlaceBidRequest placeBidRequest, Long itemId) {

        if (placeBidRequest == null || placeBidRequest.getBidAmount() == null || placeBidRequest.getUserId() == null ||
                itemId == null) {
            throw new BiddingException(EnumMessage.INVALID_REQUEST.getErrorCode(),EnumMessage.INVALID_REQUEST.getErrorMsg());
        }

        Item item = itemService.getItemById(itemId);
        Bidder bidder = bidderService.getBidderById(placeBidRequest.getUserId());

        if (placeBidRequest.getBidAmount() < item.getMinimumBasePrice()) {
            throw new BiddingException(EnumMessage.INVALID_BID_AMOUNT.getErrorCode(),EnumMessage.INVALID_BID_AMOUNT.getErrorMsg());
        }

        if (item.getMaxBid() != null) {
            Double currentMaxPrice = item.getMaxBid().getBidPrice();
            if (currentMaxPrice + item.getStepRate() > placeBidRequest.getBidAmount()) {

                createBid(placeBidRequest.getBidAmount(),item,bidder, EnumBidStatus.REJECTED.getId());

                return new ApiResponse(EnumMessage.BID_REJECTED.getErrorCode(), EnumMessage.BID_REJECTED.getErrorMsg());
            } else {
                createBid(placeBidRequest.getBidAmount(), item, bidder, EnumBidStatus.ACCEPTED.getId());
            }
        } else {
            createBid(placeBidRequest.getBidAmount(), item, bidder, EnumBidStatus.ACCEPTED.getId());
        }
        return new ApiResponse(EnumMessage.BID_ACCEPTED.getErrorCode(), EnumMessage.BID_ACCEPTED.getErrorMsg());
    }

    private void createBid(Double bidAmount, Item item, Bidder bidder, Long bidStatus) {
        Bid bid = new Bid();
        bid.setBidder(bidder);
        bid.setItem(item);
        bid.setBidPrice(bidAmount);
        bid.setBidTime(new Date());
        bid.setBidStatusId(bidStatus);
        bidRepository.save(bid);

        if (EnumBidStatus.ACCEPTED.getId().equals(bidStatus)) {
            item.setMaxBid(bid);
            itemService.saveItem(item);
        }
    }


}
