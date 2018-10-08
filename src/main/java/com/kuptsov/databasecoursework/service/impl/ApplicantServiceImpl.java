package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.repository.ApplicantRepository;
import com.kuptsov.databasecoursework.repository.VacancyRepository;
import com.kuptsov.databasecoursework.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final VacancyRepository vacancyRepository;
    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantServiceImpl(ApplicantRepository applicantRepository,
                                VacancyRepository vacancyRepository) {
        this.applicantRepository = applicantRepository;
        this.vacancyRepository = vacancyRepository;
    }

    @Override
    public List<Applicant> findAll() {
        return (List<Applicant>) applicantRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Applicant create(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant update(Applicant applicant) {

        Applicant current = applicantRepository.findById(applicant.getId())
                .orElseThrow(() -> new RuntimeException("Update failed! Applicant with ID=" + applicant.getId() + " not found!"));

        return applicantRepository.save(merge(current, applicant));
    }

    @Override
    public Applicant delete(Applicant applicant) {

        Applicant current = applicantRepository.findById(applicant.getId())
                .orElseThrow(() -> new RuntimeException("Delete failed! Applicant with ID=" + applicant.getId() + " not found!"));

        current.setDeleted(true);

        return applicantRepository.save(current);
    }

    @Override
    public Applicant merge(Applicant current, Applicant merge) {

        if (merge.getSurname() != null) {
            current.setSurname(merge.getSurname());
        }

        if (merge.getName() != null) {
            current.setName(merge.getName());
        }

        if (merge.getPatronymic() != null) {
            current.setPatronymic(merge.getPatronymic());
        }

        if (merge.getQualification() != null) {
            current.setQualification(merge.getQualification());
        }

        if (merge.getActivity() != null) {
            current.setActivity(merge.getActivity());
        }

        if (merge.getOtherInfo() != null) {
            current.setOtherInfo(merge.getOtherInfo());
        }

        if (merge.getWantedSalary() != null) {
            current.setWantedSalary(merge.getWantedSalary());
        }

        return current;
    }

    @Override
    public Optional<Applicant> removeSuitable(Vacancy vacancy) {

        Optional<Applicant> suitableApplicant = findSuitable(vacancy);

        suitableApplicant.ifPresent(a -> {
            a.setDeleted(true);
            applicantRepository.save(a);

            vacancy.setApplicant(a);
            vacancyRepository.save(vacancy);
        });

        return suitableApplicant;
    }

    @Override
    public Optional<Applicant> findSuitable(Vacancy vacancy) {
        return applicantRepository.findByWantedSalaryLessThanEqualAndQualificationGreaterThanEqualAndActivityAndDeletedIsFalse
                (vacancy.getOfferedSalary(), vacancy.getQualification(), vacancy.getEmployer().getActivity());
    }
}
