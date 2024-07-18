package com.rani.GameDesign.author;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findAllByFirstnameContaining(String param);

    Author findAllByEmail(String param);

}
