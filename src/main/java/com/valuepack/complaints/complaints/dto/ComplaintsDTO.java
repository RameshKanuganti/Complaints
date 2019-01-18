package com.valuepack.complaints.complaints.dto;

import java.sql.Timestamp;

public class ComplaintsDTO {

    private Long id;

    private String name;

    private Long complaintType;

    private Long complaintSeverity;

    private String subject;

    private String description;

    private String filePath;

    private Long franchise;

    private Long user;

    private boolean complaintStatus;

    private Long numberOfDaysTktOpened;

    private Timestamp createdDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Long complaintType) {
        this.complaintType = complaintType;
    }

    public Long getComplaintSeverity() {
        return complaintSeverity;
    }

    public void setComplaintSeverity(Long complaintSeverity) {
        this.complaintSeverity = complaintSeverity;
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public boolean isComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(boolean complaintStatus) {
        this.complaintStatus = complaintStatus;
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
