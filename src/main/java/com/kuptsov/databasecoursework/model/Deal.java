package com.kuptsov.databasecoursework.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "t_deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deal_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

    @Column(name = "commission")
    private Long commission;

    @Column(name = "deleted")
    private boolean deleted;
}
