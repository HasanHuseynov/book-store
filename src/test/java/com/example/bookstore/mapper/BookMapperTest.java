package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookMapperTest {

    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        bookMapper = Mappers.getMapper(BookMapper.class);
    }

    @Test
    public void testBookRequestToBook() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setName("Book1");


        Book book = bookMapper.fromDTO(bookRequest);

        assertThat(book).isNotNull();
        assertThat(book.getName()).isEqualTo(bookRequest.getName());

    }

    @Test
    public void testBookToBookResponse() {
        Book book = new Book();
        book.setBookId(1);
        book.setName("Book1");


        BookResponse bookResponse = bookMapper.toDTO(book);

        assertThat(bookResponse).isNotNull();
        assertThat(bookResponse.getBookId()).isEqualTo(book.getBookId());
        assertThat(bookResponse.getName()).isEqualTo(book.getName());

    }

    @Test
    public void testToDTOs() {
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setBookId(1);
        book1.setName("Book1");
        Book book2 = new Book();
        book2.setBookId(2);
        book2.setName("Book2");

        books.add(book1);
        books.add(book2);
        List<BookResponse> bookResponses = bookMapper.toDTOs(books);
        assertThat(bookResponses).isNotNull();
        assertThat(bookResponses).hasSize(2);
        assertThat(bookResponses.get(0).getBookId()).isEqualTo(book1.getBookId());
        assertThat(bookResponses.get(0).getName()).isEqualTo(book1.getName());
        assertThat(bookResponses.get(1).getBookId()).isEqualTo(book2.getBookId());
        assertThat(bookResponses.get(1).getName()).isEqualTo(book2.getName());
    }

    @Test
    public void testMapUpdateRequestToEntity() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setName("Updated Name");
        Book book = new Book();
        book.setBookId(1);
        book.setName("Original Name");
        bookMapper.mapUpdateRequestToEntity(book, bookRequest);
        assertThat(book.getName()).isEqualTo(bookRequest.getName());
    }

}
