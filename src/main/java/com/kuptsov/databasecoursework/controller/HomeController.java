package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.service.ApplicantService;
import com.kuptsov.databasecoursework.service.DealService;
import com.kuptsov.databasecoursework.service.EmploerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final EmploerService emploerService;

    private final ApplicantService applicantService;

    private final DealService dealService;

    @Autowired
    public HomeController(EmploerService emploerService,
                          ApplicantService applicantService,
                          DealService dealService) {
        this.emploerService = emploerService;
        this.applicantService = applicantService;
        this.dealService = dealService;
    }

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("emploers", emploerService.getAllEmploers());
        modelAndView.addObject("applicants", applicantService.getAllApplicants());
        modelAndView.addObject("deals", dealService.getAllDeals());
        return modelAndView;
    }
}
