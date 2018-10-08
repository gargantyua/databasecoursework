package com.kuptsov.databasecoursework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "applicant_id")
    private Long id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "qualification")
    private Integer qualification;

    @Column(name = "activity")
    private String activity;

    @Column(name = "other_info")
    private String otherInfo;

    @Column(name = "wanted_salary")
    private Long wantedSalary;

    @Column(name = "deleted")
    private boolean deleted;
}
