package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsutmb.repository.AuthorRepository;
import ru.tsutmb.entities.Author;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService implements AuthorServiceInterface {

    private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author insert(Author author) {

        return authorRepository.save(author);
    }


    @Override
    @Transactional
    public Author update(int id, String newNameAuthor) {


        Author author = Author.builder()
                .id(id)
                .name(newNameAuthor)
                .build();

        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAll() {

        return authorRepository.findAll();
    }

    @Override
    public Author getById(int id) {

        return authorRepository.getById(id);
    }

    @Override
    public Author getByName(String nameAuthor) {

        return authorRepository.findByName(nameAuthor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        authorRepository.deleteById(id);
    }
}
