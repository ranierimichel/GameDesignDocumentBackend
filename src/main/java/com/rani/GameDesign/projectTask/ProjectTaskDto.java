package com.rani.GameDesign.projectTask;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProjectTaskDto(
        @NotEmpty(message = "Description should not be empty")
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime date,
        @NotNull(message = "ProjectId should not be null")
        int projectId
) {
}
