package ru.tsutmb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsutmb.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    // SELECT * FROM genre WHERE name = ?
    Genre findByName(String name);
}
