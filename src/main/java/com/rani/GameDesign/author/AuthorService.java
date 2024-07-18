package com.rani.GameDesign.author;

import com.rani.GameDesign.project.Project;
import com.rani.GameDesign.project.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final ProjectRepository projectRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, ProjectRepository projectRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.projectRepository = projectRepository;
        this.authorMapper = authorMapper;
    }

    public AuthorResponseDto saveAuthor(AuthorDto authorDto) {
        var author = authorMapper.toAuthor(authorDto);
        authorRepository.save(author);
        return authorMapper.toAuthorResponseDto(author);
    }

    public List<AuthorResponseDto> findAllAuthor() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toAuthorResponseDto)
                .collect(Collectors.toList());
    }

    public AuthorResponseDto findAuthorById(Integer id) {
        return authorRepository.findById(id)
                .map(authorMapper::toAuthorResponseDto)
                .orElse(null);
    }

    public List<AuthorResponseDto> findAuthorByName(
            String name
    ) {
        return authorRepository.findAllByFirstnameContaining(name)
                .stream()
                .map(authorMapper::toAuthorResponseDto).toList();
    }

    public AuthorResponseDto updateAuthorByEmail(
            AuthorDto authorDto
    ) {
        Author author = authorRepository.findAllByEmail(authorDto.email());
        author.setFirstname(authorDto.firstname());
        author.setLastname(authorDto.lastname());
        authorRepository.save(author);
        return authorMapper.toAuthorResponseDto(author);
    }

    public void delete(
            Integer id
    ) {
        authorRepository.deleteById(id);
    }

    public void assignAuthorToProject(Integer authorId, Integer projectId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + authorId));
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + projectId));

        if (!author.getProjects().contains(project)) {
            author.getProjects().add(project);
            authorRepository.save(author);
        }
        if (!project.getAuthors().contains(author)) {
            project.getAuthors().add(author);
            projectRepository.save(project);
        }

    }
}
