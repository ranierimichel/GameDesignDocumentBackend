package com.rani.GameDesign.project;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public ProjectDto saveProject(ProjectDto projectDto) {
        var project = projectMapper.toProject(projectDto);
        projectRepository.save(project);
        return projectDto;
    }

    public List<ProjectResponseDto> findAllProject() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::toProjectResponseDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }
}
