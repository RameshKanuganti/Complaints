package com.valuepack.complaints.complaints.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class ComplaintType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @UniqueElements
    private String name;

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
}
