package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "negotiation_deals")
public class NegotiationDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "deal_id", referencedColumnName = "dealId")
    private Deal deal;

    @Column(name = "negotiation_time", nullable = false, updatable = false)
    private LocalDateTime negotiationTime;

    public NegotiationDeal() {
    }

    public NegotiationDeal(Deal deal) {
        this.deal = deal;
        this.negotiationTime = LocalDateTime.now();
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

    public LocalDateTime getNegotiationTime() {
        return negotiationTime;
    }

    public void setNegotiationTime(LocalDateTime negotiationTime) {
        this.negotiationTime = negotiationTime;
    }
}

