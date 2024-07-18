package com.rani.GameDesign.projectSketch;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectSketchController {
    private final ProjectSketchService projectSketchService;

    public ProjectSketchController(ProjectSketchService projectSketchService) {
        this.projectSketchService = projectSketchService;
    }

    @PostMapping("/projectsketchs")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectSketchDto post(
            @Valid @RequestBody ProjectSketchDto projectSketchDto
    ) {
        return projectSketchService.saveProjectSketch(projectSketchDto);
    }

    @GetMapping("/projectsketchs")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectSketchDto> findAllProjectTask() {
        return projectSketchService.findAllProjectSketch();
    }

    @DeleteMapping("projectsketchs/{projectsketch-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("projectsketch-id") Integer id
    ) {
        projectSketchService.delete(id);
    }
}
