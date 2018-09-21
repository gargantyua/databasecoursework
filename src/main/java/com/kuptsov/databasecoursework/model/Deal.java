package com.kuptsov.databasecoursework.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Deal {

    @Id
    @GeneratedValue
    @Column(name = "deal_id")
    private Long id;

    @ManyToOne
    private Applicant applicant;

    @ManyToOne
    private Emploer emploer;

    private String position;

    private Long commission;
}
