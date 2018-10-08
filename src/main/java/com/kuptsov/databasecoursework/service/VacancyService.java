package com.kuptsov.databasecoursework.service;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Employer;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.service.common.CommonService;

import java.util.Optional;

public interface VacancyService extends CommonService<Vacancy> {

    Iterable<Vacancy> deleteVacanciesByEmployer(Employer employer);

    Optional<Vacancy> findSuitable(Applicant applicant);

    Optional<Vacancy> closeSuitable(Applicant applicant);

    Iterable<Vacancy> findAllByEmployer(Employer employer);
}
