package com.rani.GameDesign.projectTask;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectTaskService {
    private final ProjectTaskRepository projectTaskRepository;
    private final ProjectTaskMapper projectTaskMapper;

    public ProjectTaskService(ProjectTaskRepository projectTaskRepository, ProjectTaskMapper projectTaskMapper) {
        this.projectTaskRepository = projectTaskRepository;
        this.projectTaskMapper = projectTaskMapper;
    }

    public ProjectTaskDto saveProjectTask(ProjectTaskDto projectTaskDto) {
        var projectTask = projectTaskMapper.toProjectTask(projectTaskDto);
        projectTaskRepository.save(projectTask);
        return projectTaskDto;
    }

    public List<ProjectTaskDto> findAllProjectTask() {
        return projectTaskRepository.findAll()
                .stream()
                .map(projectTaskMapper::toProjectTaskDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        projectTaskRepository.deleteById(id);
    }
}
