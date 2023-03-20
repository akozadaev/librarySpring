package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsutmb.repository.GenreDao;
import ru.tsutmb.entities.Genre;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements GenreServiceInterface {

    private final GenreDao genreDao;

    @Override
    @Transactional
    public Genre insert(Genre genre) {

        return genreDao.save(genre);
    }

    @Override
    @Transactional
    public Genre update(int id, String name) {

        Genre genre = Genre.builder()
                .id(id)
                .name(name)
                .build();

        return genreDao.save(genre);
    }

    @Override
    public List<Genre> getAll() {

        return genreDao.findAll();
    }

    @Override
    public Genre getById(int id) {

        return genreDao.getById(id);
    }

    @Override
    public Genre getByName(String name) {

        return genreDao.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        genreDao.deleteById(id);
    }
}
