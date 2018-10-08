package com.kuptsov.databasecoursework.service;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.service.common.CommonService;

import java.util.Optional;

public interface ApplicantService extends CommonService<Applicant> {

    Optional<Applicant> removeSuitable(Vacancy vacancy);

    Optional<Applicant> findSuitable(Vacancy applicant);
}
