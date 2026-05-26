package com.codingshuttle.codingshuttleRESTAPI.service;

import java.util.List;
import java.util.Map;

import com.codingshuttle.codingshuttleRESTAPI.DTO.AddProjectRequestDTO;
import com.codingshuttle.codingshuttleRESTAPI.DTO.ProjectDTO;

public interface FreelanceProjectService {

    List<ProjectDTO> getAllProjects();

    ProjectDTO getProjectById(Long id);

    ProjectDTO createProject(AddProjectRequestDTO dto);

    void deleteProject(Long id);

    ProjectDTO updateProject(Long id, AddProjectRequestDTO dto);

    ProjectDTO updatePartialProject(Long id, Map<String, Object> updates);
}