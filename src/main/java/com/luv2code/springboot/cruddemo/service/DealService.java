package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.DealRepository;
import com.luv2code.springboot.cruddemo.entity.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {

    @Autowired
    private DealRepository dealRepository;

    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    public Deal saveDeal(Deal deal) {
        return dealRepository.save(deal);
    }
}

