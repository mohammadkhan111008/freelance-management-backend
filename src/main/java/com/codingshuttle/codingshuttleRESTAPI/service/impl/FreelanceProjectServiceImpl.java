package com.codingshuttle.codingshuttleRESTAPI.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingshuttle.codingshuttleRESTAPI.DTO.AddProjectRequestDTO;
import com.codingshuttle.codingshuttleRESTAPI.DTO.ProjectDTO;
import com.codingshuttle.codingshuttleRESTAPI.entity.FreelanceProject;
import com.codingshuttle.codingshuttleRESTAPI.repository.FreelanceProjectRepository;
import com.codingshuttle.codingshuttleRESTAPI.service.FreelanceProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelanceProjectServiceImpl implements FreelanceProjectService {

    private final FreelanceProjectRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<ProjectDTO> getAllProjects() {
        return repository.findAll()
                .stream()
                .map(project -> modelMapper.map(project, ProjectDTO.class))
                .toList();
    }

    @Override
    public ProjectDTO getProjectById(Long id) {
        FreelanceProject project = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO createProject(AddProjectRequestDTO dto) {

        FreelanceProject project = modelMapper.map(dto, FreelanceProject.class);

        FreelanceProject savedProject = repository.save(project);

        return modelMapper.map(savedProject, ProjectDTO.class);
    }

    @Override
    public void deleteProject(Long id) {

        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Project not found");
        }

        repository.deleteById(id);
    }

    @Override
    public ProjectDTO updateProject(Long id, AddProjectRequestDTO dto) {

        FreelanceProject project = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        modelMapper.map(dto, project);

        FreelanceProject updatedProject = repository.save(project);

        return modelMapper.map(updatedProject, ProjectDTO.class);
    }

    @Override
    public ProjectDTO updatePartialProject(Long id, Map<String, Object> updates) {

        FreelanceProject project = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));

        updates.forEach((field, value) -> {

            switch (field) {

                case "projectName" ->
                    project.setProjectName((String) value);

                case "clientName" ->
                    project.setClientName((String) value);

                case "assignedDeveloper" ->
                    project.setAssignedDeveloper((String) value);

                case "status" ->
                    project.setStatus((String) value);

                case "cost" ->
                    project.setCost(Double.valueOf(value.toString()));

                case "dueDate" ->
                    project.setDueDate(LocalDate.parse(value.toString()));

                case "notes" ->
                    project.setNotes((String) value);

                default ->
                    throw new IllegalArgumentException("Field not supported");
            }
        });

        FreelanceProject updatedProject = repository.save(project);

        return modelMapper.map(updatedProject, ProjectDTO.class);
    }
}