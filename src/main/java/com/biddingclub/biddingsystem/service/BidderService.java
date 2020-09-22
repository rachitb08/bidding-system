package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.dto.AuctionDetailsDTO;
import com.biddingclub.biddingsystem.entity.Bidder;
import com.biddingclub.biddingsystem.entity.Item;

import java.util.List;

public interface BidderService {

    Bidder getBidderById(Long id);
}
