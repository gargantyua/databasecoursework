package com.kuptsov.databasecoursework.service;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Deal;
import com.kuptsov.databasecoursework.model.Vacancy;

import java.util.List;

public interface DealService {

    List<Deal> findAll();

    Deal generateDeal(Vacancy vacancy);

    Deal generateDeal(Applicant applicant);
}
