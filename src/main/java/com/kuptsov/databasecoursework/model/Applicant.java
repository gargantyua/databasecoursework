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
public class Applicant {

    @Id
    @GeneratedValue
    @Column(name = "applicant_id")
    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    private Integer qualification;

    private String activity;

    private String otherInfo;

    private Long salary;
}
