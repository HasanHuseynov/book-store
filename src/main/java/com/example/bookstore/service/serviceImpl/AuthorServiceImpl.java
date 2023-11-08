package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.exception.NotDataFound;
import com.example.bookstore.dto.request.AuthorRequest;
import com.example.bookstore.dto.response.AuthorResponse;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.Student;
import com.example.bookstore.entity.Subscriptions;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final EmailService emailService;

    @Override
    public List<AuthorResponse> getAllAuthors() {
        List<Author> authorEntity = authorRepository.findAll();
        log.info("Inside of author getAll");
        return authorMapper.toDTOs(authorEntity);
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        Author authorEntity = authorMapper.fromDTO(authorRequest);
        authorEntity = authorRepository.save(authorEntity);
        return authorMapper.toDTO(authorEntity);
    }

    @Override
    public void deleteById(Integer id) {
        Author authorEntity = authorRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        authorRepository.delete(authorEntity);
    }

    @Override
    public void updateAuthor(Integer id, AuthorRequest authorRequest) {
        var authorEntity = authorRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        authorMapper.mapUpdateRequestToEntity(authorEntity, authorRequest);
        authorRepository.save(authorEntity);
    }
    @Override
    public void notifySubscribedStudents(Author author, Book newBook) {
        List<Subscriptions> subscriptions = author.getSubscriptions();
        for (Subscriptions subscription : subscriptions) {
            Student student = subscription.getStudent();
            emailService.sendEmailNotification(student, author, newBook);
        }
    }
    @Override
    public Author getAuthor(Integer authorId) {
        return authorRepository.findById(authorId).orElse(null);
    }

}
