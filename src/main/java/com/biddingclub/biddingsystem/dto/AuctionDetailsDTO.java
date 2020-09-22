package com.biddingclub.biddingsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuctionDetailsDTO implements Serializable {

    private String itemCode;
    private Double highestBid;
    private Double stepRate;
}
