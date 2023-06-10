package ru.tsutmb.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import ru.tsutmb.entities.Author;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJdbcTest
class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void tstAuthor() {
        Author tstAuthor = Author.builder()
                .id(1)
                .name("Сергей Лукьяненко")
//                .name("Alexey")
                .build();
        System.out.println(tstAuthor.getName());
        authorRepository.save(tstAuthor);
        Author actualAuthor = authorRepository.getById(1);
        assertThat(actualAuthor).isEqualTo(tstAuthor);

    }
}