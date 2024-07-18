package com.rani.GameDesign.project;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectDto post(
            @Valid @RequestBody ProjectDto projectDto
    ) {
        return projectService.saveProject(projectDto);
    }

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectResponseDto> findAllProject() {
        return projectService.findAllProject();
    }

    @DeleteMapping("projects/{project-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("project-id") Integer id
    ) {
        projectService.delete(id);
    }
}
