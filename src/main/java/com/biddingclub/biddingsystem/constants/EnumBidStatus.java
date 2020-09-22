package com.biddingclub.biddingsystem.constants;

public enum EnumBidStatus {
    ACCEPTED(1L,"ACCEPTED"), REJECTED(2L,"REJECTED");

    private final Long id;
    private final String statusName;

    EnumBidStatus(Long id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public static Long getStatusByName(String statusName) {
        for (EnumBidStatus enumAuctionStatus : values()) {
            if (enumAuctionStatus.statusName.equals(statusName)) {
                return enumAuctionStatus.id;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

}
