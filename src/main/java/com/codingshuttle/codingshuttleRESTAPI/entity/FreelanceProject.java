package com.codingshuttle.codingshuttleRESTAPI.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class FreelanceProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String projectName;

    private String clientName;

    private String assignedDeveloper;

    private String status;

    private Double cost;

    private LocalDate dueDate;

    private String notes;
}