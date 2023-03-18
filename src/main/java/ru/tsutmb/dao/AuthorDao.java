package ru.tsutmb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsutmb.domain.Author;

public interface AuthorDao extends JpaRepository<Author, Integer> {

    // SELECT * FROM author WHERE name = ?
    Author findByName(String name);
}
