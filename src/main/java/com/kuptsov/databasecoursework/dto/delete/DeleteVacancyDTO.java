package com.kuptsov.databasecoursework.dto.delete;

import com.kuptsov.databasecoursework.validation.VacancyIsExistsById;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DeleteVacancyDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @VacancyIsExistsById
    @NotNull
    private Long id;
}
