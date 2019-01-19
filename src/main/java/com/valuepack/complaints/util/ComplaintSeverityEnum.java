package com.valuepack.complaints.util;

public enum ComplaintSeverityEnum {

    GENERAL_INFORMATION("General Information"),
    IMPORTANT("Important"),
    HAMPERING_OPERATIONS("Hampering Operations"),
    CRITICAL("Critical");

    private String complaintSeverity;

    ComplaintSeverityEnum(String complaintSeverity) {
        this.complaintSeverity = complaintSeverity;
    }

    public String getComplaintSeverity() {
        return complaintSeverity;
    }
}
