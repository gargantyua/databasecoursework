package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.dto.create.CreateVacancyDTO;
import com.kuptsov.databasecoursework.dto.delete.DeleteVacancyDTO;
import com.kuptsov.databasecoursework.dto.update.UpdateVacancyDTO;
import com.kuptsov.databasecoursework.mapper.VacancyMapper;
import com.kuptsov.databasecoursework.model.Vacancy;
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
@RequestMapping("/vacancy")
public class VacancyController {

    private final DealService dealService;
    private final VacancyMapper vacancyMapper;
    private final VacancyService vacancyService;
    private final ApplicantService applicantService;

    @Autowired
    public VacancyController(VacancyService vacancyService,
                             VacancyMapper vacancyMapper,
                             ApplicantService applicantService,
                             DealService dealService) {
        this.vacancyService = vacancyService;
        this.vacancyMapper = vacancyMapper;
        this.applicantService = applicantService;
        this.dealService = dealService;
    }

    @PostMapping("/create")
    public String createVacancy(@ModelAttribute @Validated CreateVacancyDTO createVacancyDTO,
                                BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Vacancy vacancy = vacancyService.create(vacancyMapper.toEntity(createVacancyDTO));
            applicantService.removeSuitable(vacancy).ifPresent(dealService::generateDeal);
        }

        return "redirect:/";
    }

    @PostMapping("/remove")
    public String deleteVacancy(@ModelAttribute @Validated DeleteVacancyDTO deleteVacancyDTO,
                                BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            vacancyService.delete(vacancyMapper.toEntity(deleteVacancyDTO));
        }

        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateVacancy(@ModelAttribute @Validated UpdateVacancyDTO updateVacancyDTO,
                                BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            Vacancy vacancy = vacancyService.update(vacancyMapper.toEntity(updateVacancyDTO));
            applicantService.removeSuitable(vacancy).ifPresent(dealService::generateDeal);
        }

        return "redirect:/";
    }
}
