package com.kuptsov.databasecoursework.dto.update;

import com.kuptsov.databasecoursework.validation.EmployerIsExistsById;
import com.kuptsov.databasecoursework.validation.UniqueEmployerTitle;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class UpdateEmployerDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @NotNull
    @EmployerIsExistsById
    private Long id;

    @UniqueEmployerTitle
    private String title;

    private String activity;

    private String address;

    private String telephone;
}
