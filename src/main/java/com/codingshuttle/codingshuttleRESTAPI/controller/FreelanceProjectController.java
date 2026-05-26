package com.codingshuttle.codingshuttleRESTAPI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingshuttle.codingshuttleRESTAPI.DTO.AddProjectRequestDTO;
import com.codingshuttle.codingshuttleRESTAPI.DTO.ProjectDTO;
import com.codingshuttle.codingshuttleRESTAPI.service.FreelanceProjectService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = {
    "http://localhost:5173",
    "https://managefreelancer.netlify.app"
})
public class FreelanceProjectController {

    private final FreelanceProjectService service;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(service.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getProjectById(id));
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(
            @RequestBody AddProjectRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.createProject(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO> updateProject(
            @PathVariable Long id,
            @RequestBody AddProjectRequestDTO dto) {

        return ResponseEntity.ok(service.updateProject(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDTO> updatePartialProject(
            @PathVariable Long id,
            @RequestBody Map<String, Object> updates) {

        return ResponseEntity.ok(service.updatePartialProject(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {

        service.deleteProject(id);

        return ResponseEntity.noContent().build();
    }
}