package com.luv2code.springboot.cruddemo.DTO;

import java.time.LocalDateTime;

public class DealInProcessDTO {

    private Long dealId;  // Foreign key reference to deal
    private String email;
    private String phone;
    private LocalDateTime dealMadeTime;
    private double askingAmount;
    private double offeredAmount;
    private String stage;
    private String employeeId;

    // Constructors
    public DealInProcessDTO() {
    }

    public DealInProcessDTO(Long dealId, String email, String phone, LocalDateTime dealMadeTime, double askingAmount, double offeredAmount, String stage, String employeeId) {
        this.dealId = dealId;
        this.email = email;
        this.phone = phone;
        this.dealMadeTime = dealMadeTime;
        this.askingAmount = askingAmount;
        this.offeredAmount = offeredAmount;
        this.stage = stage;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
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

