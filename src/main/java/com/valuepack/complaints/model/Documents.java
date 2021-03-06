package com.valuepack.complaints.model;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Documents extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String documentName;

    private String documentImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "soldcase_id", nullable = false)
    private SoldCase soldcase;

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

    public SoldCase getSoldcase() {
        return soldcase;
    }

    public void setSoldcase(SoldCase soldcase) {
        this.soldcase = soldcase;
    }
}
