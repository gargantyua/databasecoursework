package com.kuptsov.databasecoursework.validation.impl;

import com.kuptsov.databasecoursework.repository.EmployerRepository;
import com.kuptsov.databasecoursework.validation.EmployerIsExistsByTitle;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployerIsExitsByTitleValidator implements ConstraintValidator<EmployerIsExistsByTitle, String> {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerIsExitsByTitleValidator(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public void initialize(EmployerIsExistsByTitle constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return employerRepository.findByTitleAndDeletedIsFalse(value).isPresent();
    }
}
