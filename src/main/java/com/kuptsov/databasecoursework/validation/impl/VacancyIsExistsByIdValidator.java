package com.kuptsov.databasecoursework.validation.impl;

import com.kuptsov.databasecoursework.repository.VacancyRepository;
import com.kuptsov.databasecoursework.validation.VacancyIsExistsById;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VacancyIsExistsByIdValidator implements ConstraintValidator<VacancyIsExistsById, Long> {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyIsExistsByIdValidator(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public void initialize(VacancyIsExistsById constraintAnnotation) {
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        return vacancyRepository.findByIdAndDeletedIsFalse(value).isPresent();
    }
}
