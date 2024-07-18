package com.rani.GameDesign.playerControl;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerControlController {
    private final PlayerControlService playerControlService;

    public PlayerControlController(PlayerControlService playerControlService) {
        this.playerControlService = playerControlService;
    }

    @PostMapping("/playercontrols")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerControlDto post(
            @Valid @RequestBody PlayerControlDto playerControlDto
    ) {
        return playerControlService.savePlayerControl(playerControlDto);
    }

    @GetMapping("/playercontrols")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerControlDto> findAllPlayerControl() {
        return playerControlService.findAllPlayerControl();
    }

    @DeleteMapping("playercontrols/{playercontrol-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("playercontrol-id") Integer id
    ) {
        playerControlService.delete(id);
    }
}
