package com.valuepack.complaints.model;

import javax.persistence.*;

@Entity
@Table(name = "compliant_status")
public class CompliantStatus extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
