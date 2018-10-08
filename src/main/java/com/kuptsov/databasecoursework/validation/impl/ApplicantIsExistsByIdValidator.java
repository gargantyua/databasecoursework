package com.kuptsov.databasecoursework.validation.impl;

import com.kuptsov.databasecoursework.repository.ApplicantRepository;
import com.kuptsov.databasecoursework.validation.ApplicantIsExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ApplicantIsExistsByIdValidator implements ConstraintValidator<ApplicantIsExistsById, Long>{

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantIsExistsByIdValidator(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public void initialize(ApplicantIsExistsById constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return applicantRepository.findByIdAndDeletedIsFalse(value).isPresent();
    }
}
