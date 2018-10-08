package com.kuptsov.databasecoursework.validation;

import com.kuptsov.databasecoursework.validation.impl.UniqueEmployerTitleValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmployerTitleValidator.class)
public @interface UniqueEmployerTitle {

    String message() default "{com.kuptsov.databasecourcework.UniqueEmployerTitle.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

