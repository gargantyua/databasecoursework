package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
}
