package com.kuptsov.databasecoursework.validation;

import com.kuptsov.databasecoursework.validation.impl.EmployerIsExitsByTitleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployerIsExitsByTitleValidator.class)
public @interface VacancyIsExistsById {

    String message() default "{com.kuptsov.databasecourcework.constraint.VacancyIsExistsById.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
