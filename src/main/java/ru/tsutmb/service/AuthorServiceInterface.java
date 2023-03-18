package ru.tsutmb.service;


import ru.tsutmb.entities.Author;

import java.util.List;

public interface AuthorServiceInterface {

    Author insert(Author author);

    Author update(int id, String newNameAuthor);

    List<Author> getAll();

    Author getById(int id);

    Author getByName(String nameAuthor);

    void deleteById(int id);
}
