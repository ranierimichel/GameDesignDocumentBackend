package com.rani.GameDesign.playerControl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerControlService {
    private final PlayerControlRepository playerControlRepository;
    private final PlayerControlMapper playerControlMapper;

    public PlayerControlService(PlayerControlRepository playerControlRepository, PlayerControlMapper playerControlMapper) {
        this.playerControlRepository = playerControlRepository;
        this.playerControlMapper = playerControlMapper;
    }

    public PlayerControlDto savePlayerControl(PlayerControlDto playerControlDto){
        var playerControl = playerControlMapper.toPlayerControl(playerControlDto);
        playerControlRepository.save(playerControl);
        return playerControlDto;
    }

    public List<PlayerControlDto> findAllPlayerControl() {
        return playerControlRepository.findAll()
                .stream()
                .map(playerControlMapper::toPlayerControlDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        playerControlRepository.deleteById(id);
    }

}
