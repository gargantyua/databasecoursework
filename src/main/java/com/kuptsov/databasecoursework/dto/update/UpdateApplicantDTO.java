package com.kuptsov.databasecoursework.dto.update;

import com.kuptsov.databasecoursework.validation.ApplicantIsExistsById;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateApplicantDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @NotNull
    @ApplicantIsExistsById
    private Long id;

    private String surname;

    private String name;

    private String patronymic;

    @PositiveOrZero
    @Max(1000)
    private Integer qualification;

    private String activity;

    private String otherInfo;

    @PositiveOrZero
    @Max(Long.MAX_VALUE)
    private Long wantedSalary;
}
