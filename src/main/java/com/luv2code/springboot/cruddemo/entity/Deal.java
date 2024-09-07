package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    private String dealerName;
    private String email;
    private String number;

    @Embedded
    private WorkplaceAddress workplaceAddress;

    private double amount;

    @JsonFormat(pattern = "HH:mm:ss dd/MM/yy")
    @Column(name = "deal_made_time", nullable = false, updatable = false)
    private LocalDateTime dealMadeTime;

    @PrePersist
    public void prePersist() {
        this.dealMadeTime = LocalDateTime.now();
    }

    public Deal(Long dealId, LocalDateTime dealMadeTime, double amount, WorkplaceAddress workplaceAddress, String number, String email, String dealerName) {
        this.dealId = dealId;
        this.dealMadeTime = dealMadeTime;
        this.amount = amount;
        this.workplaceAddress = workplaceAddress;
        this.number = number;
        this.email = email;
        this.dealerName = dealerName;
    }

    public Deal() {
    }

    // Getters and Setters

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public LocalDateTime getDealMadeTime() {
        return dealMadeTime;
    }

    public void setDealMadeTime(LocalDateTime dealMadeTime) {
        this.dealMadeTime = dealMadeTime;
    }

    public WorkplaceAddress getWorkplaceAddress() {
        return workplaceAddress;
    }

    public void setWorkplaceAddress(WorkplaceAddress workplaceAddress) {
        this.workplaceAddress = workplaceAddress;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @Embeddable
    static class WorkplaceAddress {
        private String city;
        private String state;
        private String road;
        private String houseNumber;

        // Getters and Setters

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public void setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
        }

        public String getRoad() {
            return road;
        }

        public void setRoad(String road) {
            this.road = road;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public WorkplaceAddress(String city, String state, String road, String houseNumber) {
            this.city = city;
            this.state = state;
            this.road = road;
            this.houseNumber = houseNumber;
        }

        public WorkplaceAddress() {
        }
    }
}



