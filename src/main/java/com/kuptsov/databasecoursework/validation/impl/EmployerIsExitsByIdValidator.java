package com.kuptsov.databasecoursework.validation.impl;

import com.kuptsov.databasecoursework.repository.EmployerRepository;
import com.kuptsov.databasecoursework.validation.EmployerIsExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployerIsExitsByIdValidator implements ConstraintValidator<EmployerIsExistsById, Long>{

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerIsExitsByIdValidator(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void initialize(EmployerIsExistsById constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return employerRepository.findByIdAndDeletedIsFalse(value).isPresent();
    }
}
