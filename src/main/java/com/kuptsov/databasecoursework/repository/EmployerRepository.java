package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Long> {

    Optional<Employer> findByTitle(String title);

    Iterable<Employer> findAllByDeletedIsFalse();

    Optional<Employer> findByIdAndDeletedIsFalse(Long id);

    Optional<Employer> findByTitleAndDeletedIsFalse(String title);
}
