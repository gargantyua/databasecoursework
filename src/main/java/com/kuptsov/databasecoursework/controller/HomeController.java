package com.kuptsov.databasecoursework.controller;

import com.kuptsov.databasecoursework.service.EmploerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final EmploerService emploerService;

    @Autowired
    public HomeController(EmploerService emploerService) {
        this.emploerService = emploerService;
    }

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("emploers", emploerService.getAllEmploers());
        return modelAndView;
    }
}
