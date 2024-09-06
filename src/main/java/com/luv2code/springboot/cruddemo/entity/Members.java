package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "members")
public class Members {

    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "pw", length = 68, nullable = false)
    private String pw;

    @Column(name = "active", nullable = false)
    private boolean active;

    // Default constructor
    public Members() {
    }

    // Constructor with all fields
    public Members(String userId, String pw, boolean active) {
        this.userId = userId;
        this.pw = pw;
        this.active = active;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Members{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", active=" + active +
                '}';
    }
}

