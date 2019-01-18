package com.valuepack.complaints.complaints.model;

import com.valuepack.complaints.complaints.util.UserActiveType;

import javax.persistence.*;

@Entity
public class Franchise extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)

    private UserActiveType activeType;
}
