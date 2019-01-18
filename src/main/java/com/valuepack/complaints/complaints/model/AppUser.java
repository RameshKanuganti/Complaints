package com.valuepack.complaints.complaints.model;

import javax.persistence.*;

@Entity
@Table(name = "app_user")
public class AppUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
