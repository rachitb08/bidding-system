package com.biddingclub.biddingsystem.service;

import com.biddingclub.biddingsystem.dto.AuctionDetailsDTO;
import com.biddingclub.biddingsystem.entity.Item;
import com.biddingclub.biddingsystem.response.ApiResponse;

import java.util.List;

public interface ItemService {

    List<AuctionDetailsDTO> getItemsByStatus(String status);

    Item getItemById(Long id);

    Item saveItem(Item item);
}
