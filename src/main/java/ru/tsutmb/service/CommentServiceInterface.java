package ru.tsutmb.service;


import ru.tsutmb.entities.Comment;

import java.util.List;

public interface CommentServiceInterface {
    Comment insert(String content, int bookId);

    List<Comment> getAll();

    Comment getById(int id);

    List<Comment> getByBookId(int id);

    void update(int id, String content);

    void deleteById(int id);
}
