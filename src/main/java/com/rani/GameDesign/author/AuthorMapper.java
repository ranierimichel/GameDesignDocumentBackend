package com.rani.GameDesign.author;

import org.springframework.stereotype.Service;

@Service
public class AuthorMapper {

    public Author toAuthor(AuthorDto dto) {
        return new Author(
                dto.firstname(),
                dto.lastname(),
                dto.email()
        );
    }

    public AuthorResponseDto toAuthorResponseDto(Author author) {
        return new AuthorResponseDto(author.getFirstname());
    }
}
