package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.dto.create.CreateApplicantDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteApplicantDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateApplicantDTO;
import com.kuptsov.databasecoursework.mapper.ApplicantMapper;
import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.service.ApplicantService;
import com.kuptsov.databasecoursework.service.DealService;
import com.kuptsov.databasecoursework.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    private final DealService dealService;
    private final VacancyService vacancyService;
    private final ApplicantMapper applicantMapper;
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService,
                               ApplicantMapper applicantMapper,
                               VacancyService vacancyService,
                               DealService dealService) {
        this.applicantService = applicantService;
        this.applicantMapper = applicantMapper;
        this.vacancyService = vacancyService;
        this.dealService = dealService;
    }

    @PostMapping("/create")
    public String createApplicant(@ModelAttribute @Validated CreateApplicantDTO createApplicantDTO,
                                  BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Applicant applicant = applicantService.create(applicantMapper.toEntity(createApplicantDTO));
            vacancyService.closeSuitable(applicant).ifPresent(dealService::generateDeal);
        }

        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateApplicant(@ModelAttribute @Validated UpdateApplicantDTO updateApplicantDTO,
                                  BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Applicant applicant = applicantService.update(applicantMapper.toEntity(updateApplicantDTO));
            vacancyService.closeSuitable(applicant).ifPresent(dealService::generateDeal);
        }

        return "redirect:/";
    }

    @PostMapping("/remove")
    public String deleteApplicant(@ModelAttribute @Validated DeleteApplicantDTO deleteApplicantDTO,
                                  BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            applicantService.delete(applicantMapper.toEntity(deleteApplicantDTO));
        }

        return "redirect:/";
    }
}
