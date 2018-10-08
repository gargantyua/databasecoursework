package com.kuptsov.databasecoursework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employer_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "activity")
    private String activity;

    @Column(name = "address")
    private String address;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "deleted")
    private boolean deleted;
}
