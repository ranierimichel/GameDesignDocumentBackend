package com.rani.GameDesign.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rani.GameDesign.author.AuthorResponseDto;
import com.rani.GameDesign.playerControl.PlayerControlDto;
import com.rani.GameDesign.projectSketch.ProjectSketchDto;
import com.rani.GameDesign.projectTask.ProjectTaskDto;

import java.time.LocalDateTime;
import java.util.List;

public record ProjectResponseDto(
        String title,
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime date,
        List<AuthorResponseDto> authors,
        List<PlayerControlDto> playerControls,
        List<ProjectTaskDto> projectTasks,
        ProjectSketchDto projectSketch
) {
}
