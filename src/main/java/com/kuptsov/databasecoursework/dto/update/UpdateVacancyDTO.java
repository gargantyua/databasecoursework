package com.kuptsov.databasecoursework.dto.update;

import com.kuptsov.databasecoursework.validation.VacancyIsExistsById;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateVacancyDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @VacancyIsExistsById
    @NotNull
    private Long id;

    @PositiveOrZero
    @Max(1000)
    private Integer qualification;

    private String position;

    @PositiveOrZero
    @Max(Long.MAX_VALUE)
    private Long offeredSalary;
}
