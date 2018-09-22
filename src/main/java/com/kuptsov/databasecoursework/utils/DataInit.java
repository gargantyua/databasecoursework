package com.kuptsov.databasecoursework.utils;

import com.kuptsov.databasecoursework.repository.ApplicantRepository;
import com.kuptsov.databasecoursework.repository.DealRepository;
import com.kuptsov.databasecoursework.repository.EmploerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationRunner {

    private final EmploerRepository emploerRepository;

    private final ApplicantRepository applicantRepository;

    private final DealRepository dealRepository;

    @Autowired
    public DataInit(EmploerRepository emploerRepository,
                    ApplicantRepository applicantRepository,
                    DealRepository dealRepository) {
        this.emploerRepository = emploerRepository;
        this.applicantRepository = applicantRepository;
        this.dealRepository = dealRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        dealRepository.saveAll(DataGenerator.generateDeals(
                applicantRepository.saveAll(DataGenerator.generateApplicants()),
                emploerRepository.saveAll(DataGenerator.generateEmploers()))
        );
    }
}
