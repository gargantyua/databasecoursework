package com.kuptsov.databasecoursework.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Emploer {

    @Id
    @GeneratedValue
    @Column(name = "emploer_id")
    private Long id;

    private String title;

    private String activity;

    private String address;

    private String telephone;
}
