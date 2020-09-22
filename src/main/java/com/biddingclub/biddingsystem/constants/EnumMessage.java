package com.biddingclub.biddingsystem.constants;

public enum EnumMessage {

    INVALID_REQUEST(101,"Request is invalid"),
    SUCCESS(200,"Suceess"),
    INTERNAL_SERVER_ERROR(400,"Internal Server Error"),
    AUCTION_NOT_FOUND(404,"Auction not found");

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
