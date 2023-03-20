package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsutmb.repository.GenreRepository;
import ru.tsutmb.entities.Genre;


import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements GenreServiceInterface {

    private final GenreRepository genreRepository;

    @Override
    @Transactional
    public Genre insert(Genre genre) {

        return genreRepository.save(genre);
    }

    @Override
    @Transactional
    public Genre update(int id, String name) {

        Genre genre = Genre.builder()
                .id(id)
                .name(name)
                .build();

        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> getAll() {

        return genreRepository.findAll();
    }

    @Override
    public Genre getById(int id) {

        return genreRepository.getById(id);
    }

    @Override
    public Genre getByName(String name) {

        return genreRepository.findByName(name);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        genreRepository.deleteById(id);
    }
}
