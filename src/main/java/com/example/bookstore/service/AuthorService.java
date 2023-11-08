package com.example.bookstore.service;

import com.example.bookstore.dto.request.AuthorRequest;
import com.example.bookstore.dto.response.AuthorResponse;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;

import java.util.List;

public interface AuthorService {
    List<AuthorResponse> getAllAuthors();
    void deleteById(Integer id);
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    void updateAuthor(Integer id, AuthorRequest authorRequest);
    void notifySubscribedStudents(Author author, Book newBook);
    Author getAuthor(Integer authorId);

}
