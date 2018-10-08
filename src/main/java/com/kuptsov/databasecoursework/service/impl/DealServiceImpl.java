package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Deal;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.repository.DealRepository;
import com.kuptsov.databasecoursework.repository.VacancyRepository;
import com.kuptsov.databasecoursework.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final VacancyRepository vacancyRepository;

    @Autowired
    public DealServiceImpl(DealRepository dealRepository,
                           VacancyRepository vacancyRepository) {
        this.dealRepository = dealRepository;
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public List<Deal> findAll() {
        return (List<Deal>) dealRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Deal generateDeal(Vacancy vacancy) {
        return dealRepository.save(
                Deal.builder()
                .employer(vacancy.getEmployer())
                .applicant(vacancy.getApplicant())
                .vacancy(vacancy)
                .commission(vacancy.getOfferedSalary() * 2)
                .build()
        );
    }

    @Override
    public Deal generateDeal(Applicant applicant) {

        Vacancy vacancy = vacancyRepository.findByApplicant_Id(applicant.getId())
                .orElseThrow(() -> new RuntimeException("Generate deal by applicantID failed! Applicant with ID=" + applicant.getId() + " not found!"));

        return generateDeal(vacancy);
    }
}
