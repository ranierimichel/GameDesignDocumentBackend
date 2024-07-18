package com.rani.GameDesign.projectSketch;

import com.rani.GameDesign.project.Project;
import com.rani.GameDesign.project.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectSketchService {
    private final ProjectSketchRepository projectSketchRepository;
    private final ProjectRepository projectRepository;
    private final ProjectSketchMapper projectSketchMapper;

    public ProjectSketchService(ProjectSketchRepository projectSketchRepository, ProjectRepository projectRepository, ProjectSketchMapper projectSketchMapper) {
        this.projectSketchRepository = projectSketchRepository;
        this.projectRepository = projectRepository;
        this.projectSketchMapper = projectSketchMapper;
    }

    public ProjectSketchDto saveProjectSketch(ProjectSketchDto projectSketchDto) {
        if (projectSketchDto.type().equals("video")) {
            var videoSketch = projectSketchMapper.toVideoSketch(projectSketchDto);
            projectSketchRepository.save(videoSketch);

            var project = projectRepository.findById(projectSketchDto.projectId()).orElse(new Project());
            project.setProjectSketch(videoSketch);
            projectRepository.save(project);

        } else {
            var fileSketch = projectSketchMapper.toFileSketch(projectSketchDto);
            projectSketchRepository.save(fileSketch);

            var project = projectRepository.findById(projectSketchDto.projectId()).orElse(new Project());
            project.setProjectSketch(fileSketch);
            projectRepository.save(project);

        }
        return projectSketchDto;
    }

    public List<ProjectSketchDto> findAllProjectSketch() {
        return projectSketchRepository.findAll()
                .stream()
                .map(projectSketchMapper::toProjectSketchDto)
                .collect(Collectors.toList());
    }

    public void delete(Integer id) {
        projectSketchRepository.deleteById(id);
    }
}
