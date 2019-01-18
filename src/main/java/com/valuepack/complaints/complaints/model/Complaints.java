package com.valuepack.complaints.complaints.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "complaints")
public class Complaints extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @NotNull
    private Long complaintType;

    @NotNull
    private Long complaintSeverity;

    @NotNull
    private String subject;

    private String description;

    private String filePath;

    @NotNull
    private Long franchise;

    @NotNull
    private Long appUser;

    @NotNull
    private boolean complaintStatus;

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

    public Long getAppUser() {
        return appUser;
    }

    public void setAppUser(Long appUser) {
        this.appUser = appUser;
    }

    public boolean isComplaintStatus() {
        return complaintStatus;
    }

    public void setComplaintStatus(boolean complaintStatus) {
        this.complaintStatus = complaintStatus;
    }
}
