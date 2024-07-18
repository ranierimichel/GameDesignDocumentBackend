package com.rani.GameDesign.projectSketch;

import jakarta.validation.constraints.NotNull;

public record ProjectSketchDto(
        String name,
        int size,
        String url,
        String type,
        int length,
        @NotNull(message = "ProjectId should not be null")
        int projectId
) {
}
