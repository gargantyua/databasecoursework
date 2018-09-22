package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.repository.ApplicantRepository;
import com.kuptsov.databasecoursework.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return (List<Applicant>) applicantRepository.findAll();
    }
}
