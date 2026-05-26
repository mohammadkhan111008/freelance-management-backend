package com.codingshuttle.codingshuttleRESTAPI.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ProjectDTO {

    private Long id;

    private String projectName;

    private String clientName;

    private String assignedDeveloper;

    private String status;

    private Double cost;

    private LocalDate dueDate;

    private String notes;
}