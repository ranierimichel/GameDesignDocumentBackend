package com.rani.GameDesign.projectTask;

import com.rani.GameDesign.project.Project;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProjectTask {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectTask() {
    }

    public ProjectTask(String description, LocalDateTime date) {
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
