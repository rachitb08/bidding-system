package com.biddingclub.biddingsystem.constants;

public enum EnumMessage {

    INVALID_REQUEST(101,"Request is invalid"),
    SUCCESS(200,"Suceess"),
    BID_ACCEPTED(201,"Bid is accepted"),
    INTERNAL_SERVER_ERROR(400,"Internal Server Error"),
    AUCTION_NOT_FOUND(404,"Auction not found"),
    BIDDER_NOT_FOUND(405,"Bidder not found"),
    BID_REJECTED(406,"Bid is rejected"),
    INVALID_BID_AMOUNT(407,"Invalid Bid Amount"),
    AUCTION_EXPIRED(408,"Auction has expired");

    private final int errorCode;
    private final String errorMsg;

    private EnumMessage(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
