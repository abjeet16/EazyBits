package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "role", length = 50, nullable = false)
    private String role;

    // Many roles can belong to one member
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Members member;

    // Default constructor
    public Roles() {
    }

    // Constructor with all fields
    public Roles(String userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "userId='" + userId + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

