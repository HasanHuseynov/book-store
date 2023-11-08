package com.example.bookstore.service;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Student;

public interface EmailService {

    void sendEmailNotification(Student student, Author author, Book book);


}
