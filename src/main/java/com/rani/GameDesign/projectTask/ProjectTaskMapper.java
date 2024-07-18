package com.rani.GameDesign.projectTask;

import com.rani.GameDesign.project.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskMapper {
    public ProjectTask toProjectTask(ProjectTaskDto dto) {
        var projectTask = new ProjectTask();
        projectTask.setDescription(dto.description());
        projectTask.setDate(dto.date());

        var project = new Project();
        project.setId(dto.projectId());

        projectTask.setProject(project);
        return projectTask;

    }

    public ProjectTaskDto toProjectTaskDto(ProjectTask projectTask) {
        return new ProjectTaskDto(
                projectTask.getDescription(),
                projectTask.getDate(),
                projectTask.getProject().getId()
        );
    }
}
