package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacted_deals")
public class ContactedDeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "deal_id", referencedColumnName = "dealId")
    private Deal deal;

    @Column(name = "contacted_time", nullable = false, updatable = false)
    private LocalDateTime contactedTime;

    public ContactedDeal() {
    }

    public ContactedDeal(Deal deal) {
        this.deal = deal;
        this.contactedTime = LocalDateTime.now();
    }

    // Getters and setters
}
