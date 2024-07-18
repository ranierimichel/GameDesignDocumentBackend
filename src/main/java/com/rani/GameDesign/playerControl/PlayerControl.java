package com.rani.GameDesign.playerControl;

import com.rani.GameDesign.project.Project;
import jakarta.persistence.*;

@Entity
public class PlayerControl {
    @Id
    @GeneratedValue
    private Integer id;
    private String PlayerObject;
    private String PlayerCamera;
    private String PlayerMovement;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public PlayerControl() {
    }

    public PlayerControl(String playerObject, String playerCamera, String playerMovement) {
        PlayerObject = playerObject;
        PlayerCamera = playerCamera;
        PlayerMovement = playerMovement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerObject() {
        return PlayerObject;
    }

    public void setPlayerObject(String playerObject) {
        PlayerObject = playerObject;
    }

    public String getPlayerCamera() {
        return PlayerCamera;
    }

    public void setPlayerCamera(String playerCamera) {
        PlayerCamera = playerCamera;
    }

    public String getPlayerMovement() {
        return PlayerMovement;
    }

    public void setPlayerMovement(String playerMovement) {
        PlayerMovement = playerMovement;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
