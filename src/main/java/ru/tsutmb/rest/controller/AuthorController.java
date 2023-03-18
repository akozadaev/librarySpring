package ru.tsutmb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsutmb.entities.Author;
import ru.tsutmb.rest.dto.AuthorDto;
import ru.tsutmb.service.AuthorServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorServiceInterface authorServiceInterface;

    @PostMapping("/author")
    public AuthorDto createNewAuthor(@RequestBody AuthorDto authorDto) {

        Author author = authorServiceInterface.insert(AuthorDto.toDomainObject(authorDto));
        return AuthorDto.toDto(author);
    }

    @GetMapping("/author")
    public List<AuthorDto> getAllAuthors() {

        return authorServiceInterface
                .getAll()
                .stream()
                .map(AuthorDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/author/{id}")
    public AuthorDto getAuthorById(@PathVariable int id) {

        return AuthorDto.toDto(authorServiceInterface.getById(id));
    }

    @GetMapping("/author/name")
    public AuthorDto getAuthorByName(@RequestParam String name) {

        return AuthorDto.toDto(authorServiceInterface.getByName(name));
    }

    @PostMapping("/author/{id}/name")
    public AuthorDto updateNameById(
            @PathVariable int id,
            @RequestParam String name
    ) {

        return AuthorDto.toDto(
                authorServiceInterface.update(id, name)
        );
    }

    @DeleteMapping("/author/{id}")
    public void deleteAuthorById(@PathVariable int id) {

        authorServiceInterface.deleteById(id);
    }

}
