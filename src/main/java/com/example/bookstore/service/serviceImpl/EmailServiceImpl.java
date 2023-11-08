package com.example.bookstore.service.serviceImpl;


import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Student;
import com.example.bookstore.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Override
    public void sendEmailNotification(Student student, Author author, Book book) {
        String subject = "New Book Notification";
        String message = "Dear " + student.getName() + ",\n\n" +
                "We are excited to inform you about a new book added by your subscribed author, " + author.getName() + ":\n\n" +
                "Book Title: " + book.getName() + "\n" +
                "Author: " + author.getName() + "\n" +
                "Stay tuned for more updates from your favorite author!\n\n" +
                "Best regards,\n" +
                "Your Bookstore";
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(student.getUser().getEmail()); // Assuming you have an email field in the Student entity
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }


}
