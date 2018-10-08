package com.kuptsov.databasecoursework.dto.delete;

import com.kuptsov.databasecoursework.validation.ApplicantIsExistsById;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class DeleteApplicantDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @NotNull
    @ApplicantIsExistsById
    private Long id;
}
