package com.valuepack.complaints.dto;

import com.valuepack.complaints.model.BaseEntity;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SoldCaseDTO extends BaseEntity {

    private Long id;

    private String vehicleNo;

    private String modelNo;

    private Double estimatedSalePrice;

    private String customerSignature;

    private Long leadId;

    private Timestamp soldDate;

    private List<DocumentsDTO> documents = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public Double getEstimatedSalePrice() {
        return estimatedSalePrice;
    }

    public void setEstimatedSalePrice(Double estimatedSalePrice) {
        this.estimatedSalePrice = estimatedSalePrice;
    }

    public String getCustomerSignature() {
        return customerSignature;
    }

    public void setCustomerSignature(String customerSignature) {
        this.customerSignature = customerSignature;
    }

    public Long getLeadId() {
        return leadId;
    }

    public void setLeadId(Long leadId) {
        this.leadId = leadId;
    }

    public Timestamp getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Timestamp soldDate) {
        this.soldDate = soldDate;
    }

    public List<DocumentsDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentsDTO> documents) {
        this.documents = documents;
    }
}
