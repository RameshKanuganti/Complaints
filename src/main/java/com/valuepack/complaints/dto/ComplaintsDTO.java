package com.valuepack.complaints.dto;

import java.sql.Timestamp;

public class ComplaintsDTO {

    private Long id;

    private String subject;

    private String description;

    private String complaintType;

    private String complaintSeverity;

    private String complaintStatus;

    private String filePath;

    private Long franchise;

    private Long appUser;

    private Long numberOfDaysTktOpened;

    private Timestamp createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getComplaintSeverity() {
        return complaintSeverity;
    }

    public void setComplaintSeverity(String complaintSeverity) {
        this.complaintSeverity = complaintSeverity;
    }

    public String getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(String complaintStatus) {
        this.complaintStatus = complaintStatus;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFranchise() {
        return franchise;
    }

    public void setFranchise(Long franchise) {
        this.franchise = franchise;
    }

    public Long getAppUser() {
        return appUser;
    }

    public void setAppUser(Long appUser) {
        this.appUser = appUser;
    }

    public Long getNumberOfDaysTktOpened() {
        return numberOfDaysTktOpened;
    }

    public void setNumberOfDaysTktOpened(Long numberOfDaysTktOpened) {
        this.numberOfDaysTktOpened = numberOfDaysTktOpened;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
