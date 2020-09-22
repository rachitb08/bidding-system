package com.biddingclub.biddingsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BiddingException extends RuntimeException {

    private int errorCode;
    private String errorMessage;

    public BiddingException() {
        super();
    }

    public BiddingException(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
