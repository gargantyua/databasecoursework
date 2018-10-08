package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {

    Iterable<Applicant> findAllByDeletedIsFalse();

    Optional<Applicant> findByIdAndDeletedIsFalse(Long id);

    Optional<Applicant> findByWantedSalaryLessThanEqualAndQualificationGreaterThanEqualAndActivityAndDeletedIsFalse(Long wantedSalary, Integer qualification, String activity);
}
