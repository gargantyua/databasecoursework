package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.dto.create.CreateApplicantDTO;
import com.kuptsov.databasecoursework.dto.create.CreateEmployerDTO;
import com.kuptsov.databasecoursework.dto.create.CreateVacancyDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteApplicantDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteEmployerDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteVacancyDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateApplicantDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateEmployerDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateVacancyDTO;
import com.kuptsov.databasecoursework.service.ApplicantService;
import com.kuptsov.databasecoursework.service.DealService;
import com.kuptsov.databasecoursework.service.EmployerService;
import com.kuptsov.databasecoursework.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final DealService dealService;
    private final VacancyService vacancyService;
    private final EmployerService employerService;
    private final ApplicantService applicantService;

    @Autowired
    public HomeController(EmployerService employerService,
                          ApplicantService applicantService,
                          DealService dealService,
                          VacancyService vacancyService) {
        this.employerService = employerService;
        this.applicantService = applicantService;
        this.dealService = dealService;
        this.vacancyService = vacancyService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("employers", employerService.findAll());
        model.addAttribute("applicants", applicantService.findAll());
        model.addAttribute("deals", dealService.findAll());
        model.addAttribute("vacancies", vacancyService.findAll());

        model.addAttribute("createVacancyDTO", new CreateVacancyDTO());
        model.addAttribute("updateVacancyDTO", new UpdateVacancyDTO());
        model.addAttribute("deleteVacancyDTO", new DeleteVacancyDTO());

        model.addAttribute("createApplicantDTO", new CreateApplicantDTO());
        model.addAttribute("updateApplicantDTO", new UpdateApplicantDTO());
        model.addAttribute("deleteApplicantDTO", new DeleteApplicantDTO());

        model.addAttribute("createEmployerDTO", new CreateEmployerDTO());
        model.addAttribute("updateEmployerDTO", new UpdateEmployerDTO());
        model.addAttribute("deleteEmployerDTO", new DeleteEmployerDTO());

        return "index";
    }
}
