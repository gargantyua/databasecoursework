package com.kuptsov.databasecoursework.validation;

import com.kuptsov.databasecoursework.validation.impl.EmployerIsExitsByIdValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployerIsExitsByIdValidator.class)
public @interface EmployerIsExistsById {

    String message() default "{com.kuptsov.databasecourcework.constraint.EmployerIsExistsById.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}