package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.constants.EnumAuctionStatus;
import com.biddingclub.biddingsystem.constants.EnumMessage;
import com.biddingclub.biddingsystem.dto.AuctionDetailsDTO;
import com.biddingclub.biddingsystem.entity.Bidder;
import com.biddingclub.biddingsystem.entity.Item;
import com.biddingclub.biddingsystem.exception.BiddingException;
import com.biddingclub.biddingsystem.repository.BidderRepository;
import com.biddingclub.biddingsystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BidderServiceImpl implements BidderService {

    @Autowired
    BidderRepository bidderRepository;

    @Override
    public Bidder getBidderById(Long id) {
        return bidderRepository.findById(id).orElseThrow(() -> new BiddingException(EnumMessage.BIDDER_NOT_FOUND.getErrorCode(),EnumMessage.BIDDER_NOT_FOUND.getErrorMsg()));
    }
}
