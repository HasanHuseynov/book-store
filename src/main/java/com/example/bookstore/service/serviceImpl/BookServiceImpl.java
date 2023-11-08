package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.exception.NotDataFound;
import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.entity.Student;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.mapper.StudentMapper;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.StudentRepository;
import com.example.bookstore.service.AuthorService;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private  final StudentRepository studentRepository;


    private final AuthorService authorService;
    private final StudentMapper studentMapper;
    private final BookMapper bookMapper;

    @Override
    public List<BookResponse> getAllBooks() {
        var bookEntity = bookRepository.findAll();
        log.info("Inside of book getAll");
        return bookMapper.toDTOs(bookEntity);

    }

    @Override
    public BookResponse createBook(BookRequest bookRequest, Integer authorId) {
        var bookEntity = bookMapper.fromDTO(bookRequest);
        bookEntity = bookRepository.save(bookEntity);
        authorService.notifySubscribedStudents(authorService.getAuthor(authorId),bookEntity);
        return bookMapper.toDTO(bookEntity);
    }

    @Override
    public void deleteById(Integer id) {
        var bookEntity = bookRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        bookRepository.delete(bookEntity);
    }

    @Override
    public void updateBook(Integer id, BookRequest bookRequest) {
        var bookEntity = bookRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        bookMapper.mapUpdateRequestToEntity(bookEntity, bookRequest);
        bookRepository.save(bookEntity);

    }
    @Override
    public boolean deleteBookByAuthority(Integer bookId, Integer authorId) {
        var book = bookRepository.findById(bookId).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        if (book.getAuthor().getAuthorId().equals(authorId)) {
            bookRepository.delete(book);
            return true;
        }
        return false;}

    public List<StudentResponse> getReadersForBook(Integer bookId) {
        List<Student> students = studentRepository.findStudentsByBookId(bookId);
        return studentMapper.toDTOs(students);
    }
}
