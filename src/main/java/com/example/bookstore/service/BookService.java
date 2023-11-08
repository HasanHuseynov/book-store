package com.example.bookstore.service;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.StudentResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> getAllBooks();
    void deleteById(Integer id);
    BookResponse createBook(BookRequest bookRequest, Integer authorId);
    void updateBook(Integer id, BookRequest bookRequest);

    boolean deleteBookByAuthority(Integer bookId, Integer authorId);

    List<StudentResponse> getReadersForBook(Integer bookId);

}
