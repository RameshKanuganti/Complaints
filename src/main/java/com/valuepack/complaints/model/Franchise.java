package com.valuepack.complaints.model;

import javax.persistence.*;

@Entity
public class Franchise extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
