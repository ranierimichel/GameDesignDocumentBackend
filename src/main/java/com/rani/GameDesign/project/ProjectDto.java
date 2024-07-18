package com.rani.GameDesign.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record ProjectDto(
        @NotEmpty(message = "Title should not be empty")
        String title,
        @NotEmpty(message = "Description should not be empty")
        String description,
        @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
        LocalDateTime date
) {
}
