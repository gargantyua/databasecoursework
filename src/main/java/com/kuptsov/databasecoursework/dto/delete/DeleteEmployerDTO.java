package com.kuptsov.databasecoursework.dto.delete;

import com.kuptsov.databasecoursework.validation.EmployerIsExistsById;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class DeleteEmployerDTO {

    @Positive
    @Max(Long.MAX_VALUE)
    @NotNull
    @EmployerIsExistsById
    private Long id;
}
