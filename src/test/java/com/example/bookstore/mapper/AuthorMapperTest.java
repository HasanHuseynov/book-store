package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.AuthorRequest;
import com.example.bookstore.dto.response.AuthorResponse;
import com.example.bookstore.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthorMapperTest {

    private AuthorMapper authorMapper;

    @BeforeEach
    public void setUp() {
        authorMapper = Mappers.getMapper(AuthorMapper.class);
    }

    @Test
    public void testAuthorRequestToAuthor() {
        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setName("John Doe");
        authorRequest.setAge(30);

        Author author = authorMapper.fromDTO(authorRequest);

        assertThat(author).isNotNull();
        assertThat(author.getName()).isEqualTo(authorRequest.getName());
        assertThat(author.getAge()).isEqualTo(authorRequest.getAge());
    }

    @Test
    public void testAuthorToAuthorResponse() {
        Author author = new Author();
        author.setAuthorId(1);
        author.setName("Jane Smith");
        author.setAge(40);

        AuthorResponse authorResponse = authorMapper.toDTO(author);

        assertThat(authorResponse).isNotNull();
        assertThat(authorResponse.getAuthorId()).isEqualTo(author.getAuthorId());
        assertThat(authorResponse.getName()).isEqualTo(author.getName());
        assertThat(authorResponse.getAge()).isEqualTo(author.getAge());
    }

    @Test
    public void testToDTOs() {
        List<Author> authors = new ArrayList<>();
        Author author1 = new Author();
        author1.setAuthorId(1);
        author1.setName("John Doe");
        author1.setAge(30);
        Author author2 = new Author();
        author2.setAuthorId(2);
        author2.setName("Jane Smith");
        author2.setAge(40);
        authors.add(author1);
        authors.add(author2);
        List<AuthorResponse> authorResponses = authorMapper.toDTOs(authors);
        assertThat(authorResponses).isNotNull();
        assertThat(authorResponses).hasSize(2);
        assertThat(authorResponses.get(0).getAuthorId()).isEqualTo(author1.getAuthorId());
        assertThat(authorResponses.get(0).getName()).isEqualTo(author1.getName());
        assertThat(authorResponses.get(0).getAge()).isEqualTo(author1.getAge());
        assertThat(authorResponses.get(1).getAuthorId()).isEqualTo(author2.getAuthorId());
        assertThat(authorResponses.get(1).getName()).isEqualTo(author2.getName());
        assertThat(authorResponses.get(1).getAge()).isEqualTo(author2.getAge());
    }

    @Test
    public void testMapUpdateRequestToEntity() {
        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setName("Updated Name");
        authorRequest.setAge(35);
        Author author = new Author();
        author.setAuthorId(1);
        author.setName("Original Name");
        author.setAge(30);
        authorMapper.mapUpdateRequestToEntity(author, authorRequest);
        assertThat(author.getName()).isEqualTo(authorRequest.getName());
        assertThat(author.getAge()).isEqualTo(authorRequest.getAge());
    }

}
