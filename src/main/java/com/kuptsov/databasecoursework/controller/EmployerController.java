package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.dto.create.CreateEmployerDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteEmployerDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateEmployerDTO;
import com.kuptsov.databasecoursework.mapper.EmployerMapper;
import com.kuptsov.databasecoursework.model.Employer;
import com.kuptsov.databasecoursework.service.ApplicantService;
import com.kuptsov.databasecoursework.service.DealService;
import com.kuptsov.databasecoursework.service.EmployerService;
import com.kuptsov.databasecoursework.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    private final DealService dealService;
    private final EmployerMapper employerMapper;
    private final VacancyService vacancyService;
    private final EmployerService employerService;
    private final ApplicantService applicantService;

    @Autowired
    public EmployerController(EmployerService employerService,
                              VacancyService vacancyService,
                              EmployerMapper employerMapper,
                              ApplicantService applicantService,
                              DealService dealService) {
        this.employerService = employerService;
        this.vacancyService = vacancyService;
        this.employerMapper = employerMapper;
        this.applicantService = applicantService;
        this.dealService = dealService;
    }

    @PostMapping("/create")
    public String createEmployer(@ModelAttribute @Validated CreateEmployerDTO createEmployerDTO,
                                 BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            employerService.create(employerMapper.toEntity(createEmployerDTO));
        }

        return "redirect:/";
    }

    @PostMapping("/remove")
    public String deleteEmployer(@ModelAttribute @Validated DeleteEmployerDTO deleteEmployerDTO,
                                 BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Employer employer = employerService.delete(employerMapper.toEntity(deleteEmployerDTO));
            vacancyService.deleteVacanciesByEmployer(employer);
        }

        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateEmployer(@ModelAttribute @Validated UpdateEmployerDTO updateEmployerDTO,
                                 BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Employer employer = employerService.update(employerMapper.toEntity(updateEmployerDTO));
            vacancyService.findAllByEmployer(employer).forEach(v -> applicantService.removeSuitable(v).ifPresent(dealService::generateDeal));
        }

        return "redirect:/";
    }
}
