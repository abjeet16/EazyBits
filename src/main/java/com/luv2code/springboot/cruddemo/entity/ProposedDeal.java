package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "proposed_deals")
public class ProposedDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "deal_id", referencedColumnName = "dealId")
    private Deal deal;

    @Column(name = "proposed_time", nullable = false, updatable = false)
    private LocalDateTime proposedTime;

    public ProposedDeal() {
    }

    public ProposedDeal(Deal deal) {
        this.deal = deal;
        this.proposedTime = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public LocalDateTime getProposedTime() {
        return proposedTime;
    }

    public void setProposedTime(LocalDateTime proposedTime) {
        this.proposedTime = proposedTime;
    }
}

