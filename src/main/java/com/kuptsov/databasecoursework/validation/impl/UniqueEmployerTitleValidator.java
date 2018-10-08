package com.kuptsov.databasecoursework.validation.impl;

import com.kuptsov.databasecoursework.repository.EmployerRepository;
import com.kuptsov.databasecoursework.validation.UniqueEmployerTitle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmployerTitleValidator implements ConstraintValidator<UniqueEmployerTitle, String>{

    private final EmployerRepository employerRepository;

    @Autowired
    public UniqueEmployerTitleValidator(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void initialize(UniqueEmployerTitle constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !employerRepository.findByTitle(value).isPresent();
    }
}