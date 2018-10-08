package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Employer;
import com.kuptsov.databasecoursework.repository.EmployerRepository;
import com.kuptsov.databasecoursework.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository emploerRepository) {
        this.employerRepository = emploerRepository;
    }

    @Override
    public List<Employer> findAll() {
        return (List<Employer>) employerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Employer update(Employer employer) {

        Employer current = employerRepository.findById(employer.getId())
                .orElseThrow(() -> new RuntimeException("Update failed! Employer with ID=" + employer.getId() + " not found!"));

        return employerRepository.save(merge(current, employer));
    }

    @Override
    public Employer delete(Employer employer) {

        Employer current = employerRepository.findById(employer.getId())
                .orElseThrow(() -> new RuntimeException("Delete failed! Employer with ID=" + employer.getId() + " not found!"));

        current.setDeleted(true);

        return employerRepository.save(current);
    }

    @Override
    public Employer create(Employer employer) {
        return employerRepository.save(employer);
    }

    @Override
    public Employer merge(Employer current, Employer merge) {

        if(merge.getTitle() != null) {
            current.setTitle(merge.getTitle());
        }

        if (merge.getActivity() != null) {
            current.setActivity(merge.getActivity());
        }

        if (merge.getAddress() != null) {
            current.setAddress(merge.getAddress());
        }

        if (merge.getTelephone() != null) {
            current.setTelephone(merge.getTelephone());
        }

        return current;
    }
}
