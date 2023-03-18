package ru.tsutmb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsutmb.entities.Genre;
import ru.tsutmb.rest.dto.GenreDto;
import ru.tsutmb.service.GenreServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GenreController {

    private final GenreServiceInterface genreServiceInterface;

    @PostMapping("/genre")
    public GenreDto createNewGenre(@RequestBody GenreDto genreDto) {

        Genre genre = genreServiceInterface.insert(GenreDto.toDomainObject(genreDto));
        return GenreDto.toDto(genre);
    }

    @GetMapping("/genre")
    public List<GenreDto> getAllGenres() {

        return genreServiceInterface
                .getAll()
                .stream()
                .map(GenreDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/genre/{id}")
    public GenreDto getGenreById(@PathVariable int id) {

        return GenreDto.toDto(genreServiceInterface.getById(id));
    }

    @GetMapping("/genre/name")
    public GenreDto getGenreByName(@RequestParam String name) {

        return GenreDto.toDto(genreServiceInterface.getByName(name));
    }

    @PostMapping("/genre/{id}/name")
    public GenreDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return GenreDto.toDto(
                genreServiceInterface.update(id, name)
        );
    }

    @DeleteMapping("/genre/{id}")
    public void deleteGenreById(@PathVariable int id) {

        genreServiceInterface.deleteById(id);
    }

}
