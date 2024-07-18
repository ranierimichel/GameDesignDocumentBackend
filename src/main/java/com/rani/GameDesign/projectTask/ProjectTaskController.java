package com.rani.GameDesign.projectTask;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectTaskController {
    private final ProjectTaskService projectTaskService;

    public ProjectTaskController(ProjectTaskService projectTaskService) {
        this.projectTaskService = projectTaskService;
    }

    @PostMapping("/projecttasks")
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectTaskDto post(
            @Valid @RequestBody ProjectTaskDto projectTaskDto
    ) {
        return projectTaskService.saveProjectTask(projectTaskDto);
    }

    @GetMapping("/projecttasks")
    @ResponseStatus(HttpStatus.OK)
    public List<ProjectTaskDto> findAllProjectTask() {
        return projectTaskService.findAllProjectTask();
    }

    @DeleteMapping("projecttasks/{projecttask-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("projecttask-id") Integer id
    ) {
        projectTaskService.delete(id);
    }
}
