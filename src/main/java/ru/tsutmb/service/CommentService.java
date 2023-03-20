package ru.tsutmb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.tsutmb.repository.BookDao;
import ru.tsutmb.repository.CommentDao;
import ru.tsutmb.entities.Book;
import ru.tsutmb.entities.Comment;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService implements CommentServiceInterface {

    private final CommentDao commentDao;
    private final BookDao bookDao;

    @Override
    @Transactional
    public Comment insert(String content, int bookId) {

        Book book = bookDao.findById(bookId).orElse(null);

        Comment comment = Comment.builder()
                .content(content)
                .book(book)
                .build();

        return commentDao.save(comment);
    }

    @Override
    public List<Comment> getAll() {

        return commentDao.findAll();
    }

    @Override
    public Comment getById(int id) {

        return commentDao.getById(id);
    }

    @Override
    public List<Comment> getByBookId(int id) {

        return commentDao.findByBookId(id);
    }

    @Override
    @Transactional
    public void update(int id, String content) {

        commentDao.updateContentById(id, content);
    }

    @Override
    @Transactional
    public void deleteById(int id) {

        commentDao.deleteById(id);
    }
}
