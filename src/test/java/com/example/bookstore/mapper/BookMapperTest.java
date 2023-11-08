//package com.example.bookstore.mapper;
//
//import com.example.bookstore.dto.request.BookRequest;
//import com.example.bookstore.dto.response.BookResponse;
//import com.example.bookstore.entity.Book;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mapstruct.factory.Mappers;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class BookMapperTest {
//    private BookMapper bookMapper;
//
//    @BeforeEach
//    public void setUp() {
//        bookMapper = Mappers.getMapper(BookMapper.class);
//    }
//
//    @Test
//    public void testFromDTO() {
//        BookRequest bookRequest = new BookRequest();
//        bookRequest.setName("John Doe");
//
//        Book book = bookMapper.fromDTO(bookRequest);
//
//        assertEquals("John Doe", book.getName());
//    }
//
//    @Test
//    public void testToDTO() {
//        Book book = new Book();
//        book.setBookId(1);
//        book.setName("Hasan");
//
//        BookResponse bookResponse = bookMapper.toDTO(book);
//
//        assertEquals(1, bookResponse.getBookId());
//        assertEquals("Ali", bookResponse.getName());
//    }
//
//    @Test
//    public void testToDTOs() {
//        Book book1 = new Book();
//        book1.setBookId(1);
//        book1.setName("Book 1");
//
//        Book book2 = new Book();
//        book2.setBookId(2);
//        book2.setName("Book 2");
//
//        List<Book> books = List.of(book1, book2);
//
//        List<BookResponse> bookResponses = bookMapper.toDTOs(books);
//
//        assertEquals(2, bookResponses.size());
//        assertEquals("Book 1", bookResponses.get(0).getName());
//        assertEquals("Book 2", bookResponses.get(1).getName());
//    }
//
//    @Test
//    public void testMapUpdateRequestToEntity() {
//        Book existingBook = new Book();
//        existingBook.setBookId(1);
//        existingBook.setName("Existing Book");
//
//        BookRequest updatedBookRequest = new BookRequest();
//        updatedBookRequest.setName("Updated Book");
//
//        bookMapper.mapUpdateRequestToEntity(existingBook, updatedBookRequest);
//
//        assertEquals("Updated Book", existingBook.getName());
//    }
//}
