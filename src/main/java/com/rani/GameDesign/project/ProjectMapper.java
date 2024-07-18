package com.rani.GameDesign.project;

import com.rani.GameDesign.author.AuthorMapper;
import com.rani.GameDesign.playerControl.PlayerControlMapper;
import com.rani.GameDesign.projectSketch.ProjectSketchMapper;
import com.rani.GameDesign.projectTask.ProjectTaskMapper;
import org.springframework.stereotype.Service;

@Service
public class ProjectMapper {
    private final AuthorMapper authorMapper;
    private final PlayerControlMapper playerControlMapper;
    private final ProjectTaskMapper projectTaskMapper;
    private final ProjectSketchMapper projectSketchMapper;

    public ProjectMapper(AuthorMapper authorMapper, PlayerControlMapper playerControlMapper, ProjectTaskMapper projectTaskMapper, ProjectSketchMapper projectSketchMapper) {
        this.authorMapper = authorMapper;
        this.playerControlMapper = playerControlMapper;
        this.projectTaskMapper = projectTaskMapper;
        this.projectSketchMapper = projectSketchMapper;
    }

    public Project toProject(ProjectDto dto) {
        return new Project(
                dto.title(),
                dto.description(),
                dto.date()
        );
    }

    public ProjectDto toProjectDto(Project project) {
        return new ProjectDto(
                project.getTitle(),
                project.getDescription(),
                project.getDate()
        );
    }

    public ProjectResponseDto toProjectResponseDto(Project project) {
        return new ProjectResponseDto(
                project.getTitle(),
                project.getDescription(),
                project.getDate(),
                project.getAuthors().stream().map(authorMapper::toAuthorResponseDto).toList(),
                project.getPlayerControls().stream().map(playerControlMapper::toPlayerControlDto).toList(),
                project.getProjectTasks().stream().map(projectTaskMapper::toProjectTaskDto).toList(),
                projectSketchMapper.toProjectSketchDto(project.getProjectSketch())
        );
    }
}
