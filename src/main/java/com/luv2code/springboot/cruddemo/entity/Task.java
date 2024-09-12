package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

// NOT WORKING ///

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false, referencedColumnName = "user_id")
    private Members employee;

    @ManyToOne
    @JoinColumn(name = "deal_id",nullable = false, referencedColumnName = "dealInProcessId",unique = true) // Ensure this column is not nullable in the database
    private DealInProcess dealInProcessId;

    @Column(name = "task_description" , nullable = false)
    private String taskDescription;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "status")
    private String status = "Pending"; // default status

    // Getters and setters
    public Task() {
    }

    public Task(Long id, Members employee, DealInProcess deal, String taskDescription, LocalDate deadline, String status) {
        this.id = id;
        this.employee = employee;
        this.dealInProcessId = deal;
        this.taskDescription = taskDescription;
        this.deadline = deadline;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Members getEmployee() {
        return employee;
    }

    public void setEmployee(Members employee) {
        this.employee = employee;
    }

    public DealInProcess getDeal() {
        return dealInProcessId;
    }

    public void setDeal(DealInProcess deal) {
        this.dealInProcessId = deal;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
