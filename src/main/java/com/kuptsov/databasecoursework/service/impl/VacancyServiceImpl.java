package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Applicant;
import com.kuptsov.databasecoursework.model.Employer;
import com.kuptsov.databasecoursework.model.Vacancy;
import com.kuptsov.databasecoursework.repository.ApplicantRepository;
import com.kuptsov.databasecoursework.repository.VacancyRepository;
import com.kuptsov.databasecoursework.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final ApplicantRepository applicantRepository;

    @Autowired
    public VacancyServiceImpl(VacancyRepository vacancyRepository,
                              ApplicantRepository applicantRepository) {
        this.vacancyRepository = vacancyRepository;
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Vacancy> findAll() {
        return (List<Vacancy>) vacancyRepository.findAllByApplicantIsNullAndDeletedIsFalse();
    }

    @Override
    public Vacancy create(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy update(Vacancy vacancy) {

        Vacancy current = vacancyRepository.findById(vacancy.getId())
                .orElseThrow(() -> new RuntimeException("Update failed! Vacancy with ID=" + vacancy.getId() + " not found!"));;

        return vacancyRepository.save(merge(current, vacancy));
    }

    @Override
    public Vacancy delete(Vacancy vacancy) {

        Vacancy current = vacancyRepository.findById(vacancy.getId())
                .orElseThrow(() -> new RuntimeException("Delete failed! Vacancy with ID=" + vacancy.getId() + " not found!"));

        current.setDeleted(true);

        return vacancyRepository.save(current);
    }

    @Override
    public Iterable<Vacancy> deleteVacanciesByEmployer(Employer employer) {

        Iterable<Vacancy> vacancies = vacancyRepository.findVacanciesByEmployer_IdAndDeletedIsFalse(employer.getId());

        vacancies.forEach(v -> v.setDeleted(true));

        return vacancyRepository.saveAll(vacancies);
    }

    @Override
    public Optional<Vacancy> findSuitable(Applicant applicant) {
        return vacancyRepository.findByOfferedSalaryGreaterThanEqualAndQualificationLessThanEqualAndEmployer_ActivityAndApplicantIsNullAndDeletedIsFalse
                (applicant.getWantedSalary(), applicant.getQualification(), applicant.getActivity());
    }

    @Override
    public Optional<Vacancy> closeSuitable(Applicant applicant) {

        Optional<Vacancy> suitableVacancy = findSuitable(applicant);

        suitableVacancy.ifPresent(v -> {
            applicant.setDeleted(true);
            applicantRepository.save(applicant);

            v.setApplicant(applicant);
            vacancyRepository.save(v);
        });

        return suitableVacancy;
    }

    @Override
    public Vacancy merge(Vacancy current, Vacancy merge) {

        if (merge.getEmployer() != null) {
            current.setEmployer(merge.getEmployer());
        }

        if (merge.getApplicant() != null) {
            current.setApplicant(merge.getApplicant());
        }

        if (merge.getQualification() != null) {
            current.setQualification(merge.getQualification());
        }

        if (merge.getPosition() != null) {
            current.setPosition(merge.getPosition());
        }

        if (merge.getOfferedSalary() != null) {
            current.setOfferedSalary(merge.getOfferedSalary());
        }

        return current;
    }

    @Override
    public Iterable<Vacancy> findAllByEmployer(Employer employer) {
        return vacancyRepository.findVacanciesByEmployer_IdAndDeletedIsFalse(employer.getId());
    }
}
