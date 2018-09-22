package com.kuptsov.databasecoursework.service.impl;

import com.kuptsov.databasecoursework.model.Deal;
import com.kuptsov.databasecoursework.repository.DealRepository;
import com.kuptsov.databasecoursework.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;

    @Autowired
    public DealServiceImpl(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Override
    public List<Deal> getAllDeals() {
        return (List<Deal>) dealRepository.findAll();
    }
}
