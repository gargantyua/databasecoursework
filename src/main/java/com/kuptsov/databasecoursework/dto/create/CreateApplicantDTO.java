package com.kuptsov.databasecoursework.dto.create;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateApplicantDTO {

    @NotBlank
    private String surname;

    @NotBlank
    private String name;

    @NotBlank
    private String patronymic;

    @PositiveOrZero
    @Max(1000)
    @NotNull
    private Integer qualification;

    @NotBlank
    private String activity;

    private String otherInfo;

    @PositiveOrZero
    @Max(Long.MAX_VALUE)
    @NotNull
    private Long wantedSalary;
}
