package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Emploer;
import com.kuptsov.databasecoursework.repository.EmploerRepository;
import com.kuptsov.databasecoursework.service.EmploerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploerServiceImpl implements EmploerService {

    private final EmploerRepository emploerRepository;

    @Autowired
    public EmploerServiceImpl(EmploerRepository emploerRepository) {
        this.emploerRepository = emploerRepository;
    }

    @Override
    public List<Emploer> getAllEmploers() {
        return (List<Emploer>) emploerRepository.findAll();
    }
}
