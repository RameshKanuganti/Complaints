package com.valuepack.complaints.util;

public enum ComplaintStatusEnum {

    OPEN("Open"),
    CLOSED("Close"),
    HOLD("Hold");

    private String complaintStatus;

    ComplaintStatusEnum(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }
}
