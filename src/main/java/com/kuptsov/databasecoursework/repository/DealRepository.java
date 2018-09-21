package com.kuptsov.databasecoursework.repository;

import com.kuptsov.databasecoursework.model.Deal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {
}
