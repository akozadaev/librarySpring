package ru.tsutmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsutmb.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    // SELECT * FROM author WHERE name = ?
    Author findByName(String name);
}
