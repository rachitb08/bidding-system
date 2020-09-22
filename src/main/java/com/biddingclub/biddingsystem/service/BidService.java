package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.request.PlaceBidRequest;
import com.biddingclub.biddingsystem.response.ApiResponse;

public interface BidService {


    ApiResponse placeBid(PlaceBidRequest placeBidRequest, Long itemId);
}
