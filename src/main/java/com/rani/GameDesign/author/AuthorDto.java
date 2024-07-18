package com.rani.GameDesign.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record AuthorDto(
        @NotEmpty(message = "First name should not be empty")
        String firstname,
        String lastname,
        @Email
        @NotEmpty(message = "Email should not be empty")
        String email
) {
}
