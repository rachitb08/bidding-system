package com.biddingclub.biddingsystem.controller;

import com.biddingclub.biddingsystem.constants.EnumMessage;
import com.biddingclub.biddingsystem.constants.RequestConstants;
import com.biddingclub.biddingsystem.dto.AuctionDetailsDTO;
import com.biddingclub.biddingsystem.response.ApiResponse;
import com.biddingclub.biddingsystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AuctionController {

    @Autowired
    ItemService itemService;

    @GetMapping("/auction")
    public ApiResponse getAuctionsByStatus(
            @RequestParam(value = RequestConstants.STATUS, required = false) String status) {

        List<AuctionDetailsDTO> items = itemService.getItemsByStatus(status);
        return new ApiResponse(EnumMessage.SUCCESS.getErrorCode(), EnumMessage.SUCCESS.getErrorMsg(), items);
    }
}
