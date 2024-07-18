package com.rani.GameDesign.projectSketch;

import com.rani.GameDesign.project.Project;
import jakarta.persistence.*;

@Entity
@Inheritance
@DiscriminatorColumn(name = "sketch_type")
public class ProjectSketch {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int size;
    private String url;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public ProjectSketch() {
    }

    public ProjectSketch(String name, int size, String url, Project project) {
        this.name = name;
        this.size = size;
        this.url = url;
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
