package ru.tsutmb.service;



import ru.tsutmb.entities.Genre;

import java.util.List;

public interface GenreServiceInterface {

    Genre insert(Genre genre);

    Genre update(int id, String name);

    List<Genre> getAll();

    Genre getById(int id);

    Genre getByName(String name);

    void deleteById(int id);
}
