package com.valuepack.complaints.util;

public enum ComplaintTypeEnum {

    ACCOUNT_MANAGEMENT("Account Management"),
    TRAINING_REQUIRED("Training Required"),
    GETTING_STARTED("Getting Started"),
    BILLING("Billing"),
    OTHER("Other");

    private String complaintType;

    ComplaintTypeEnum(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintType() {
        return complaintType;
    }
}
