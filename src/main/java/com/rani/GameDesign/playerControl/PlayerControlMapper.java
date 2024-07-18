package com.rani.GameDesign.playerControl;

import com.rani.GameDesign.project.Project;
import org.springframework.stereotype.Service;

@Service
public class PlayerControlMapper {
    public PlayerControl toPlayerControl(PlayerControlDto dto) {
        var playerControl = new PlayerControl(
                dto.PlayerObject(),
                dto.PlayerCamera(),
                dto.PlayerMovement()
        );

        var project = new Project();
        project.setId(dto.projectId());

        playerControl.setProject(project);
        return playerControl;
    }

    public PlayerControlDto toPlayerControlDto(PlayerControl playerControl) {
        return new PlayerControlDto(
                playerControl.getPlayerObject(),
                playerControl.getPlayerCamera(),
                playerControl.getPlayerMovement(),
                playerControl.getProject().getId());
    }
}
