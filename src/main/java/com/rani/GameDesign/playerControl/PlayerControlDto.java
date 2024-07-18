package com.rani.GameDesign.playerControl;

import jakarta.validation.constraints.NotNull;

public record PlayerControlDto(
        String PlayerObject,
        String PlayerCamera,
        String PlayerMovement,
        @NotNull(message = "ProjectId should not be null")
        int projectId
) {
}
