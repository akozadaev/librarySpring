package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import ru.tsutmb.repository.AuthorRepository;
import ru.tsutmb.repository.BookRepository;
import ru.tsutmb.repository.GenreRepository;
import ru.tsutmb.entities.Author;
import ru.tsutmb.entities.Book;
import ru.tsutmb.entities.Genre;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements BookServiceInterface {

    private final GenreRepository genreRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorServiceInterface authorServiceInterface;
    private final GenreServiceInterface genreServiceInterface;

    @Override
    @Transactional
    public Book insert(String nameBook,
                       String nameGenre,
                       String nameAuthor) {

        Author author = authorRepository.findByName(nameAuthor);
        if (ObjectUtils.isEmpty(author)) {
            author = Author.builder()
                    .name(nameAuthor)
                    .build();
        }

        Genre genre = genreRepository.findByName(nameGenre);
        if (ObjectUtils.isEmpty(genre)) {
            genre = Genre.builder()
                    .name(nameGenre)
                    .build();
        }

        Book book = Book.builder()
                .name(nameBook)
                .author(author)
                .genre(genre)
                .build();

        return bookRepository.save(book);
    }


    @Override
    @Transactional
    public Book update(int id,
                       String nameBook,
                       String nameGenre,
                       String nameAuthor) {

        Book book = Book.builder()
                .id(id)
                .name(nameBook)
                .author(authorServiceInterface.getByName(nameAuthor))
                .genre(genreServiceInterface.getByName(nameGenre))
                .build();

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {

        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {

        return bookRepository.getById(id);
    }

    @Override
    public Book getByName(String name) {

        return bookRepository.findByName(name);
    }

    @Transactional
    @Override
    public void deleteById(int id) {

        bookRepository.deleteById(id);
    }
}
