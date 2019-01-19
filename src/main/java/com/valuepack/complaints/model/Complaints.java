package com.valuepack.complaints.model;

import com.valuepack.complaints.util.ComplaintSeverityEnum;
import com.valuepack.complaints.util.ComplaintStatusEnum;
import com.valuepack.complaints.util.ComplaintTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "complaints")
public class Complaints extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String subject;

    private String description;

    @Enumerated(EnumType.STRING)
    private ComplaintTypeEnum complaintType;

    @Enumerated(EnumType.STRING)
    private ComplaintSeverityEnum complaintSeverity;

    @Enumerated(EnumType.STRING)
    private ComplaintStatusEnum complaintStatus;

    private String filePath;

    @NotNull
    private Long franchise;

    @NotNull
    private Long appUser;

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

    public ComplaintTypeEnum getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(ComplaintTypeEnum complaintType) {
        this.complaintType = complaintType;
    }

    public ComplaintSeverityEnum getComplaintSeverity() {
        return complaintSeverity;
    }

    public void setComplaintSeverity(ComplaintSeverityEnum complaintSeverity) {
        this.complaintSeverity = complaintSeverity;
    }

    public ComplaintStatusEnum getComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(ComplaintStatusEnum complaintStatus) {
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
}
