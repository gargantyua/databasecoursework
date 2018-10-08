package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Vacancy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacancyRepository extends CrudRepository<Vacancy, Long> {

    Optional<Vacancy> findByApplicant_Id(Long id);

    Optional<Vacancy> findByIdAndDeletedIsFalse(Long id);

    Iterable<Vacancy> findAllByApplicantIsNullAndDeletedIsFalse();

    Iterable<Vacancy> findVacanciesByEmployer_IdAndDeletedIsFalse(Long id);

    Optional<Vacancy> findByOfferedSalaryGreaterThanEqualAndQualificationLessThanEqualAndEmployer_ActivityAndApplicantIsNullAndDeletedIsFalse(Long offeredSalary, Integer qualification, String activity);
}
