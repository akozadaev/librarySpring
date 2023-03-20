package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import ru.tsutmb.repository.AuthorDao;
import ru.tsutmb.repository.BookDao;
import ru.tsutmb.repository.GenreDao;
import ru.tsutmb.entities.Author;
import ru.tsutmb.entities.Book;
import ru.tsutmb.entities.Genre;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService implements BookServiceInterface {

    private final GenreDao genreDao;
    private final BookDao bookDao;
    private final AuthorDao authorDao;
    private final AuthorServiceInterface authorServiceInterface;
    private final GenreServiceInterface genreServiceInterface;

    @Override
    @Transactional
    public Book insert(String nameBook,
                       String nameGenre,
                       String nameAuthor) {

        Author author = authorDao.findByName(nameAuthor);
        if (ObjectUtils.isEmpty(author)) {
            author = Author.builder()
                    .name(nameAuthor)
                    .build();
        }

        Genre genre = genreDao.findByName(nameGenre);
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

        return bookDao.save(book);
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

        return bookDao.save(book);
    }

    @Override
    public List<Book> getAll() {

        return bookDao.findAll();
    }

    @Override
    public Book getById(int id) {

        return bookDao.getById(id);
    }

    @Override
    public Book getByName(String name) {

        return bookDao.findByName(name);
    }

    @Transactional
    @Override
    public void deleteById(int id) {

        bookDao.deleteById(id);
    }
}
