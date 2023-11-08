//package com.example.bookstore.mapper;
//
//import com.example.bookstore.dto.request.AuthorRequest;
//import com.example.bookstore.dto.response.AuthorResponse;
//import com.example.bookstore.entity.Author;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AuthorMapperTest {
//    private AuthorMapper authorMapper;
//
//    @BeforeEach
//    public void setUp() {
//        authorMapper = Mappers.getMapper(AuthorMapper.class);
//    }
//
//    @Test
//    public void testFromDTO() {
//        AuthorRequest authorRequest = new AuthorRequest();
//        authorRequest.setName("John Doe");
//        authorRequest.setAge(23);
//
//        Author author = authorMapper.fromDTO(authorRequest);
//
//        assertEquals("John Doe", author.getName());
//        assertEquals(23,author.getAge());
//    }
//
//    @Test
//    public void testToDTO() {
//        Author author = new Author();
//        author.setAuthorId(1);
//        author.setName("Hasan");
//        author.setAge(19);
//
//        AuthorResponse authorResponse = authorMapper.toDTO(author);
//
//        assertEquals(1, authorResponse.getAuthorId());
//        assertEquals("Ali", authorResponse.getName());
//        assertEquals(19, authorResponse.getAge());
//    }
//
//    @Test
//    public void testToDTOs() {
//        Author author1 = new Author();
//        author1.setAuthorId(1);
//        author1.setName("Hasan");
//
//        Author author2 = new Author();
//        author2.setAuthorId(2);
//        author2.setName("Hasan");
//
//        List<Author> authors = List.of(author1, author2);
//
//        List<AuthorResponse> authorResponses = authorMapper.toDTOs(authors);
//
//        assertEquals(2, authorResponses.size());
//
//        assertEquals("Author 1", authorResponses.get(0).getName());
//        assertEquals("Author 2", authorResponses.get(1).getName());
//    }
//
//    @Test
//    public void testMapUpdateRequestToEntity() {
//        Author existingAuthor = new Author();
//        existingAuthor.setAuthorId(1);
//        existingAuthor.setName("Existing Author");
//
//        AuthorRequest updatedAuthorRequest = new AuthorRequest();
//        updatedAuthorRequest.setName("Updated Author");
//
//        authorMapper.mapUpdateRequestToEntity(existingAuthor, updatedAuthorRequest);
//
//        assertEquals("Updated Author", existingAuthor.getName());
//    }
//}
