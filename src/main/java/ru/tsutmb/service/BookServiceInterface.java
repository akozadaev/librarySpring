package ru.tsutmb.service;


import ru.tsutmb.entities.Book;

import java.util.List;

public interface BookServiceInterface {

    Book insert(String nameBook,
                String nameGenre,
                String nameAuthor);

    Book update(int id,
                String nameBook,
                String nameGenre,
                String nameAuthor);

    List<Book> getAll();

    Book getById(int id);

    Book getByName(String name);

    void deleteById(int id);
}
