package com.kuptsov.databasecoursework.dto.create;

import com.kuptsov.databasecoursework.validation.UniqueEmployerTitle;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateEmployerDTO {

    @NotBlank
    @UniqueEmployerTitle
    private String title;

    @NotBlank
    private String activity;

    @NotBlank
    private String address;

    @NotBlank
    private String telephone;
}
