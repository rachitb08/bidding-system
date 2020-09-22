package com.biddingclub.biddingsystem.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlaceBidRequest implements Serializable {

    private Double bidAmount;
    private Long userId;
}
