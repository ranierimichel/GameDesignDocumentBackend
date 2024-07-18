package com.rani.GameDesign.author;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDto post(
           @Valid @RequestBody AuthorDto authorDto
    ) {
        return authorService.saveAuthor(authorDto);
    }

    @PostMapping("/{authorId}/assign/{projectId}")
    @ResponseStatus(HttpStatus.OK)
    public void assignAuthorInProject(
           @PathVariable Integer authorId,
           @PathVariable Integer projectId
    ) {
        authorService.assignAuthorToProject(authorId,projectId);
    }

    @PutMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponseDto put(
            @Valid @RequestBody AuthorDto authorDto
    ) {
        return authorService.updateAuthorByEmail(authorDto);
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponseDto> findAllAuthor() {
        return authorService.findAllAuthor();
    }

    @GetMapping("/authors/{author-id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorResponseDto findAuthorById(
            @PathVariable("author-id") Integer id
    ) {
        return authorService.findAuthorById(id);
    }

    @GetMapping("/authors/search/{author-name}")
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponseDto> findAuthorByName(
            @PathVariable("author-name") String name
    ) {
        return authorService.findAuthorByName(name);
    }

    @DeleteMapping("authors/{author-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("author-id") Integer id
    ) {
        authorService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
