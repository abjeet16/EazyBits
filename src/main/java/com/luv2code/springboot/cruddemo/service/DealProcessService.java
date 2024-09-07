package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.DTO.DealInProcessDTO;
import com.luv2code.springboot.cruddemo.dao.*;
import com.luv2code.springboot.cruddemo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class DealProcessService {

    @Autowired
    private ContactedDealRepository contactedDealRepository;

    @Autowired
    private ProposedDealRepository proposedDealRepository;

    @Autowired
    private NegotiationDealRepository negotiationDealRepository;

    @Autowired
    private ClosedDealRepository closedDealRepository;

    @Autowired
    private DealInProcessRepository dealInProcessRepository;

    @Autowired
    private DealRepository dealRepository;

    public void saveDealInProcess(DealInProcessDTO dealInProcessDTO) {
        // Find the deal using dealId
        Optional<Deal> optionalDeal = dealRepository.findById(dealInProcessDTO.getDealId());

        if (!optionalDeal.isPresent()) {
            throw new RuntimeException("Deal not found with id: " + dealInProcessDTO.getDealId());
        }

        Deal deal = optionalDeal.get();

        // Save deal in process data
        DealInProcess dealInProcess = new DealInProcess(
                deal,
                dealInProcessDTO.getEmail(),
                dealInProcessDTO.getPhone(),
                dealInProcessDTO.getDealMadeTime() != null ? dealInProcessDTO.getDealMadeTime() : LocalDateTime.now(),
                dealInProcessDTO.getAskingAmount(),
                dealInProcessDTO.getOfferedAmount(),
                dealInProcessDTO.getStage(),
                dealInProcessDTO.getEmployeeId()
        );

        dealInProcessRepository.save(dealInProcess);

        // Move the deal to the appropriate stage based on its stage value
        switch (dealInProcessDTO.getStage().toUpperCase()) {
            case "CONTACTED":
                saveToContacted(deal);
                break;
            case "PROPOSED":
                saveToProposed(deal);
                break;
            case "NEGOTIATION":
                saveToNegotiation(deal);
                break;
            case "CLOSED":
                saveToClosed(deal);
                break;
            default:
                throw new RuntimeException("Invalid stage provided");
        }
    }

    private void saveToContacted(Deal deal) {
        contactedDealRepository.save(new ContactedDeal(deal));
    }

    private void saveToProposed(Deal deal) {
        proposedDealRepository.save(new ProposedDeal(deal));
    }

    private void saveToNegotiation(Deal deal) {
        negotiationDealRepository.save(new NegotiationDeal(deal));
    }

    private void saveToClosed(Deal deal) {
        closedDealRepository.save(new ClosedDeal(deal));
    }
}

