package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "deal_in_process")
public class DealInProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealInProcessId;  // This is the primary key

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deal_id", nullable = false,unique = true)
    private Deal deal;  // Foreign key referencing the Deal table

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;

    @Column(name = "deal_made_time", nullable = false)
    private LocalDateTime dealMadeTime;

    @Column(nullable = false)
    private double askingAmount;
    @Column(nullable = false)
    private double offeredAmount = 0;
    @Column(nullable = false)
    private String stage;
    @Column(nullable = false)
    private String employeeId;  // Replace with the actual Employee entity class


    // Constructors
    public DealInProcess() {
    }

    public DealInProcess(Deal deal, String email, String phone, LocalDateTime dealMadeTime, double askingAmount, double offeredAmount, String stage, String employeeId) {
        this.deal = deal;
        this.email = email;
        this.phone = phone;
        this.dealMadeTime = dealMadeTime;
        this.askingAmount = askingAmount;
        this.offeredAmount = offeredAmount;
        this.stage = stage;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public Long getDealInProcessId() {
        return dealInProcessId;
    }

    public void setDealInProcessId(Long dealInProcessId) {
        this.dealInProcessId = dealInProcessId;
    }

    public Deal getDeal() {
        return deal;
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getDealMadeTime() {
        return dealMadeTime;
    }

    public void setDealMadeTime(LocalDateTime dealMadeTime) {
        this.dealMadeTime = dealMadeTime;
    }

    public double getAskingAmount() {
        return askingAmount;
    }

    public void setAskingAmount(double askingAmount) {
        this.askingAmount = askingAmount;
    }

    public double getOfferedAmount() {
        return offeredAmount;
    }

    public void setOfferedAmount(double offeredAmount) {
        this.offeredAmount = offeredAmount;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}

