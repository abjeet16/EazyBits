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

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public ContactedDeal() {
    }

    public ContactedDeal(Deal deal) {
        this.deal = deal;
        this.contactedTime = LocalDateTime.now();
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDateTime getContactedTime() {
        return contactedTime;
    }

    public void setContactedTime(LocalDateTime contactedTime) {
        this.contactedTime = contactedTime;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
