package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.constants.EnumAuctionStatus;
import com.biddingclub.biddingsystem.constants.EnumMessage;
import com.biddingclub.biddingsystem.dto.AuctionDetailsDTO;
import com.biddingclub.biddingsystem.entity.Item;
import com.biddingclub.biddingsystem.exception.BiddingException;
import com.biddingclub.biddingsystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<AuctionDetailsDTO> getItemsByStatus(String status) {

        if (StringUtils.isEmpty(status)) {
            throw new BiddingException(EnumMessage.INVALID_REQUEST.getErrorCode(),EnumMessage.INVALID_REQUEST.getErrorMsg());
        }
        int statusId = EnumAuctionStatus.getStatusByName(status.toUpperCase());
        if (statusId == 0) {
            throw new BiddingException(EnumMessage.INVALID_REQUEST.getErrorCode(),EnumMessage.INVALID_REQUEST.getErrorMsg());
        }
        List<Item> items = itemRepository.findByAuctionStatusId(statusId);
        if (CollectionUtils.isEmpty(items)) {
            throw new BiddingException(EnumMessage.AUCTION_NOT_FOUND.getErrorCode(),EnumMessage.AUCTION_NOT_FOUND.getErrorMsg());
        }
        List<AuctionDetailsDTO> auctionDetailsDTOS = new ArrayList<>();
        for (Item item :  items) {
            AuctionDetailsDTO auctionDetailsDTO = new AuctionDetailsDTO();
            auctionDetailsDTO.setItemCode(item.getName());
            auctionDetailsDTO.setHighestBid(item.getMaxBid() != null ? item.getMaxBid().getBidPrice() : null);
            auctionDetailsDTO.setStepRate(item.getStepRate());
            auctionDetailsDTOS.add(auctionDetailsDTO);
        }
        return auctionDetailsDTOS;
    }

    @Override
    public Item getItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new BiddingException(EnumMessage.AUCTION_NOT_FOUND.getErrorCode(),EnumMessage.AUCTION_NOT_FOUND.getErrorMsg()));
        if (EnumAuctionStatus.OVER.getId() == item.getAuctionStatusId() ||
                item.getEndDate().before(new Date())) {
            throw new BiddingException(EnumMessage.AUCTION_EXPIRED.getErrorCode(),EnumMessage.AUCTION_EXPIRED.getErrorMsg());
        }
        return item;
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }
}
