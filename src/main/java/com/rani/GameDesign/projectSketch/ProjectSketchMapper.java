package com.rani.GameDesign.projectSketch;

import com.rani.GameDesign.project.Project;
import com.rani.GameDesign.project.ProjectDto;
import org.springframework.stereotype.Service;

@Service
public class ProjectSketchMapper {
    public FileSketch toFileSketch(ProjectSketchDto dto) {
        var fileSketch = new FileSketch();
        fileSketch.setName(dto.name());
        fileSketch.setSize(dto.size());
        fileSketch.setUrl(dto.url());
        fileSketch.setType(dto.type());

        var project = new Project();
        project.setId(dto.projectId());

        fileSketch.setProject(project);
        return fileSketch;

    }

    public VideoSketch toVideoSketch(ProjectSketchDto dto) {
        var videoSketch = new VideoSketch();
        videoSketch.setName(dto.name());
        videoSketch.setSize(dto.size());
        videoSketch.setUrl(dto.url());
        videoSketch.setLength(dto.length());

        var project = new Project();
        project.setId(dto.projectId());

        videoSketch.setProject(project);
        return videoSketch;
    }

    public ProjectSketchDto fromFiletoProjectSketchDto(FileSketch fileSketch) {
        return new ProjectSketchDto(
                fileSketch.getName(),
                fileSketch.getSize(),
                fileSketch.getUrl(),
                fileSketch.getType(),
                0,
                fileSketch.getId()
        );
    }

    public ProjectSketchDto fromVideotoProjectSketchDto(VideoSketch videoSketch) {
        return new ProjectSketchDto(
                videoSketch.getName(),
                videoSketch.getSize(),
                videoSketch.getUrl(),
                "video",
                videoSketch.getLength(),
                videoSketch.getId()
        );
    }

    public ProjectSketchDto toProjectSketchDto(ProjectSketch projectSketch) {
        if (projectSketch == null)
            return new ProjectSketchDto("",0,"", "", 0, 0);

        return new ProjectSketchDto(
                projectSketch.getName(),
                projectSketch.getSize(),
                projectSketch.getUrl(),
                "",
                0,
                projectSketch.getId()
        );
    }
}
