package com.kuptsov.databasecoursework.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_vacancies")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacancy_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Column(name = "qualification")
    private Integer qualification;

    @Column(name = "position")
    private String position;

    @Column(name = "offered_salary")
    private Long offeredSalary;

    @Column(name = "deleted")
    private boolean deleted;
}
