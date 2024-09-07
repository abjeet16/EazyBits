package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.*;
import com.luv2code.springboot.cruddemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealsInProcess")
public class DealsInProcessController {

    @Autowired
    private ContactedDealRepository contactDealRepository;

    @Autowired
    private ProposedDealRepository proposedDealRepository;

    @Autowired
    private NegotiationDealRepository negotiationDealRepository;

    @Autowired
    private ClosedDealRepository closedDealRepository;

    @Autowired
    private DealInProcessRepository dealInProcessRepository;

    //Get all Deals in process
    @GetMapping
    public ResponseEntity<List<DealInProcess>> getAllDealInProcess(){
        List<DealInProcess> dealInProcesses = dealInProcessRepository.findAll();
        return ResponseEntity.ok(dealInProcesses);
    }

    // Get all Contact Deals
    @GetMapping("/contact")
    public ResponseEntity<List<ContactedDeal>> getAllContactDeals() {
        List<ContactedDeal> contactDeals = contactDealRepository.findAll();
        return ResponseEntity.ok(contactDeals);
    }

    // Get all Proposed Deals
    @GetMapping("/proposed")
    public ResponseEntity<List<ProposedDeal>> getAllProposedDeals() {
        List<ProposedDeal> proposedDeals = proposedDealRepository.findAll();
        return ResponseEntity.ok(proposedDeals);
    }

    // Get all Negotiation Deals
    @GetMapping("/negotiation")
    public ResponseEntity<List<NegotiationDeal>> getAllNegotiationDeals() {
        List<NegotiationDeal> negotiationDeals = negotiationDealRepository.findAll();
        return ResponseEntity.ok(negotiationDeals);
    }

    // Get all Closed Deals
    @GetMapping("/closed")
    public ResponseEntity<List<ClosedDeal>> getAllClosedDeals() {
        List<ClosedDeal> closedDeals = closedDealRepository.findAll();
        return ResponseEntity.ok(closedDeals);
    }
}

