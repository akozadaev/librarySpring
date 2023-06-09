package ru.tsutmb.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tsutmb.entities.Book;


import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Override
    @EntityGraph(attributePaths = {"genre", "author", "comments"}) // Решение N + 1, по сути внутри join
    List<Book> findAll();

    // SELECT * FROM book WHERE name = ?
    Book findByName(String name);
}
