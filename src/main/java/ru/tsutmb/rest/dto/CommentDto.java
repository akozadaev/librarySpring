package ru.tsutmb.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tsutmb.entities.Book;
import ru.tsutmb.entities.Comment;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private int id;

    private String content;

    public static Comment toDomainObject(CommentDto commentDto, Book book) {

        return new Comment(commentDto.getId(), commentDto.getContent(), book);
    }

    public static CommentDto toDto(Comment comment) {

        return new CommentDto(comment.getId(), comment.getContent());
    }

}
