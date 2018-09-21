package com.kuptsov.databasecoursework.utils;

import com.kuptsov.databasecoursework.model.Emploer;
import com.kuptsov.databasecoursework.repository.EmploerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {

    private final static int COUNT_GENERATED_ENTRIES = 15;

    private final EmploerRepository emploerRepository;

    @Autowired
    public DataInit(EmploerRepository emploerRepository) {
        this.emploerRepository = emploerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Emploer> emploers = new ArrayList<>();

        for (int i = 0; i < COUNT_GENERATED_ENTRIES; i++) {
            emploers.add(DataGenerator.generateEmploer());
        }

        emploerRepository.saveAll(emploers);
    }
}
