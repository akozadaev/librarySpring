package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsutmb.repository.BookRepository;
import ru.tsutmb.repository.CommentRepositoryo;
import ru.tsutmb.entities.Book;
import ru.tsutmb.entities.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentServiceInterface {

    private final CommentRepositoryo commentRepositoryo;
    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Comment insert(String content, int bookId) {

        Book book = bookRepository.findById(bookId).orElse(null);

        Comment comment = Comment.builder()
                .content(content)
                .book(book)
                .build();

        return commentRepositoryo.save(comment);
    }

    @Override
    public List<Comment> getAll() {

        return commentRepositoryo.findAll();
    }

    @Override
    public Comment getById(int id) {

        return commentRepositoryo.getById(id);
    }

    @Override
    public List<Comment> getByBookId(int id) {

        return commentRepositoryo.findByBookId(id);
    }

    @Override
    @Transactional
    public void update(int id, String content) {

        commentRepositoryo.updateContentById(id, content);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        commentRepositoryo.deleteById(id);
    }
}
