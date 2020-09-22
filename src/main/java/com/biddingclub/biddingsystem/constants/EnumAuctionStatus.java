package com.biddingclub.biddingsystem.constants;

public enum EnumAuctionStatus {
    RUNNING(1,"RUNNING"), OVER(2,"OVER");

    private final int id;
    private final String statusName;

    EnumAuctionStatus(int id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public static int getStatusByName(String statusName) {
        for (EnumAuctionStatus enumAuctionStatus : values()) {
            if (enumAuctionStatus.statusName.equals(statusName)) {
                return enumAuctionStatus.id;
            }
        }
        return 0;
    }

    public int getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }

}
