package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Emploer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploerRepository extends CrudRepository<Emploer, Long> {
}
