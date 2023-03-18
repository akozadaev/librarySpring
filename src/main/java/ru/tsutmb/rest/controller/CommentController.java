package ru.tsutmb.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tsutmb.entities.Comment;
import ru.tsutmb.rest.dto.CommentDto;
import ru.tsutmb.service.CommentServiceInterface;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentServiceInterface commentServiceInterface;

    @PostMapping("/comment")
    public CommentDto createNewComment(
            @RequestParam String content,
            @RequestParam int bookId
    ) {

        Comment comment = commentServiceInterface.insert(content, bookId);

        return CommentDto.toDto(comment);
    }

    @GetMapping("/comment")
    public List<CommentDto> getAllComments() {

        return commentServiceInterface
                .getAll()
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/comment/{id}/content")
    public void updateCommentById(
            @PathVariable int id,
            @RequestParam String content
    ) {

        commentServiceInterface.update(id, content);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteCommentById(@PathVariable int id) {

        commentServiceInterface.deleteById(id);
    }

    @GetMapping("/book/{id}/comment")
    public List<CommentDto> getCommentsByBookId(@PathVariable int id) {

        return commentServiceInterface
                .getByBookId(id)
                .stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }
}
