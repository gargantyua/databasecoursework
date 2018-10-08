package com.kuptsov.databasecoursework.dto.create;

import com.kuptsov.databasecoursework.validation.EmployerIsExistsByTitle;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateVacancyDTO {

    @NotBlank
    @EmployerIsExistsByTitle
    private String employerTitle;

    @NotNull
    @PositiveOrZero
    @Max(1000)
    private Integer qualification;

    @NotBlank
    private String position;

    @NotNull
    @Positive
    @Max(Long.MAX_VALUE)
    private Long offeredSalary;
}
