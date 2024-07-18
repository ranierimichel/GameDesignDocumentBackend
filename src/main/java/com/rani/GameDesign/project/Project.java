package com.rani.GameDesign.project;

import com.rani.GameDesign.author.Author;
import com.rani.GameDesign.playerControl.PlayerControl;
import com.rani.GameDesign.projectSketch.ProjectSketch;
import com.rani.GameDesign.projectTask.ProjectTask;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime date;
    @ManyToMany
    @JoinTable(
            name = "authors_projects",
            joinColumns = {
                    @JoinColumn(name = "project_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    private List<PlayerControl> playerControls;

    @OneToMany(mappedBy = "project")
    private List<ProjectTask> projectTasks;

    @OneToOne
    @JoinColumn(name = "projectSketch_id")
    private ProjectSketch projectSketch;

    public Project() {
    }

    public Project(String title, String description, LocalDateTime date) {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<PlayerControl> getPlayerControls() {
        return playerControls;
    }

    public void setPlayerControls(List<PlayerControl> playerControls) {
        this.playerControls = playerControls;
    }

    public List<ProjectTask> getProjectTasks() {
        return projectTasks;
    }

    public void setProjectTasks(List<ProjectTask> projectTasks) {
        this.projectTasks = projectTasks;
    }

    public ProjectSketch getProjectSketch() {
        return projectSketch;
    }

    public void setProjectSketch(ProjectSketch projectSketch) {
        this.projectSketch = projectSketch;
    }
}
