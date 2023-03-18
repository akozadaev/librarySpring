package ru.tsutmb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsutmb.entities.Book;
import ru.tsutmb.rest.dto.BookDto;
import ru.tsutmb.service.BookServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookServiceInterface bookServiceInterface;

    @PostMapping("/book")
    public BookDto createNewBook(
            @RequestParam String nameBook,
            @RequestParam String nameGenre,
            @RequestParam String nameAuthor
    ) {

        Book book = bookServiceInterface.insert(nameBook, nameGenre, nameAuthor);
        return BookDto.toDto(book);
    }

    @GetMapping("/book")
    public List<BookDto> getAllBooks() {

        return bookServiceInterface
                .getAll()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }


    @PostMapping("/book/{id}/")
    public BookDto updateBookById(
            @PathVariable int id,
            @RequestParam String newBookName,
            @RequestParam String newGenreName,
            @RequestParam String newAuthorName
    ) {

        Book book = bookServiceInterface.update(
                id,
                newBookName,
                newGenreName,
                newAuthorName
        );

        return BookDto.toDto(book);
    }

    @GetMapping("/book/{id}")
    public BookDto getBookById(@PathVariable int id) {

        return BookDto.toDto(bookServiceInterface.getById(id));
    }

    @GetMapping("/book/name")
    public BookDto getBookByName(@RequestParam String name) {

        return BookDto.toDto(bookServiceInterface.getByName(name));
    }

    @DeleteMapping("/book/{id}")
    //@PostMapping("/deleteBookById")
    public void deleteBookById(@PathVariable int id) {

        bookServiceInterface.deleteById(id);
    }

}
