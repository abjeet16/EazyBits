package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.DTO.DealInProcessDTO;
import com.luv2code.springboot.cruddemo.dao.DealInProcessRepository;
import com.luv2code.springboot.cruddemo.dao.DealRepository;
import com.luv2code.springboot.cruddemo.entity.Deal;
import com.luv2code.springboot.cruddemo.entity.DealInProcess;
import com.luv2code.springboot.cruddemo.service.DealProcessService;
import com.luv2code.springboot.cruddemo.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    @Autowired
    private DealRepository dealRepository;

    @Autowired
    private DealService dealService;

    @Autowired
    private DealInProcessRepository dealInProcessRepository;

    // Get all deals
    @GetMapping
    public List<Deal> getAllDeals() {
        return dealService.getAllDeals();
    }

    // Create a new deal
    @PostMapping
    public ResponseEntity<Deal> createDeal(@RequestBody Deal deal) {
        Deal savedDeal = dealService.saveDeal(deal);
        return ResponseEntity.ok(savedDeal);
    }

    @Autowired
    private DealProcessService dealProcessService;

    @PostMapping("/acceptOrder")
    public ResponseEntity<String> acceptOrder(@RequestBody DealInProcessDTO dealInProcessDTO) {
        dealProcessService.saveDealInProcess(dealInProcessDTO);
        return ResponseEntity.ok("Order accepted and saved in the corresponding stage");
    }
}


