package com.valuepack.complaints.dto;

import com.valuepack.complaints.model.BaseEntity;

public class DocumentsDTO extends BaseEntity {

    private Long id;

    private String documentName;

    private String documentImageUrl;

    private Long soldCaseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentImageUrl() {
        return documentImageUrl;
    }

    public void setDocumentImageUrl(String documentImageUrl) {
        this.documentImageUrl = documentImageUrl;
    }

    public Long getSoldCaseId() {
        return soldCaseId;
    }
    public void setSoldCaseId(Long soldCaseId) {
        this.soldCaseId = soldCaseId;
    }
}
