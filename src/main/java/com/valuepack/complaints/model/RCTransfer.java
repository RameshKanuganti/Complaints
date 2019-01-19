package com.valuepack.complaints.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "rc_transfer")
public class RCTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String vehicleNumber;

    private Timestamp dateOfSale;

    private Boolean isHypothecationNOCRecorded;

    private Timestamp hypothecationNOCDateRecorded;

    private Boolean isDocumentSubmittedToRTC;

    private Timestamp documentSubmittedToRTCDate;

    private Boolean isNewRCIssued;

    private Timestamp newRCIssuedDate;

    private String uploadNewRCCopy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Timestamp getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Timestamp dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public Boolean getHypothecationNOCRecorded() {
        return isHypothecationNOCRecorded;
    }

    public void setHypothecationNOCRecorded(Boolean hypothecationNOCRecorded) {
        isHypothecationNOCRecorded = hypothecationNOCRecorded;
    }

    public Timestamp getHypothecationNOCDateRecorded() {
        return hypothecationNOCDateRecorded;
    }

    public void setHypothecationNOCDateRecorded(Timestamp hypothecationNOCDateRecorded) {
        this.hypothecationNOCDateRecorded = hypothecationNOCDateRecorded;
    }

    public Boolean getDocumentSubmittedToRTC() {
        return isDocumentSubmittedToRTC;
    }

    public void setDocumentSubmittedToRTC(Boolean documentSubmittedToRTC) {
        isDocumentSubmittedToRTC = documentSubmittedToRTC;
    }

    public Timestamp getDocumentSubmittedToRTCDate() {
        return documentSubmittedToRTCDate;
    }

    public void setDocumentSubmittedToRTCDate(Timestamp documentSubmittedToRTCDate) {
        this.documentSubmittedToRTCDate = documentSubmittedToRTCDate;
    }

    public Boolean getNewRCIssued() {
        return isNewRCIssued;
    }

    public void setNewRCIssued(Boolean newRCIssued) {
        isNewRCIssued = newRCIssued;
    }

    public Timestamp getNewRCIssuedDate() {
        return newRCIssuedDate;
    }

    public void setNewRCIssuedDate(Timestamp newRCIssuedDate) {
        this.newRCIssuedDate = newRCIssuedDate;
    }

    public String getUploadNewRCCopy() {
        return uploadNewRCCopy;
    }

    public void setUploadNewRCCopy(String uploadNewRCCopy) {
        this.uploadNewRCCopy = uploadNewRCCopy;
    }
}
