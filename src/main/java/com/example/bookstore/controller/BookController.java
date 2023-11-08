package com.example.bookstore.controller;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/book"})
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public ResponseEntity<List<BookResponse>> getALlBook() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @PostMapping({"/author/{authorId}"})
    public ResponseEntity<BookResponse> createNewBook(@Valid @RequestBody BookRequest bookRequest, @PathVariable Integer authorId) {
        return ResponseEntity.ok(bookService.createBook(bookRequest,authorId));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteBook(@Valid @PathVariable Integer id) {
        bookService.deleteById(id);
        return ResponseEntity.ok("Book deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateBook(@Valid @PathVariable Integer id, @Valid @RequestBody BookRequest bookRequest) {
        bookService.updateBook(id, bookRequest);
        return ResponseEntity.ok("Book updated successfully!");
    }
    @DeleteMapping("/author-delete/{bookId}")
    public ResponseEntity<String> deleteBookByAuthority(@PathVariable Integer bookId, @RequestParam Integer authorId) {
        boolean deleted = bookService.deleteBookByAuthority(bookId, authorId);
        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You do not have permission to delete this book.");
        }
    }
    @GetMapping("/readers/{bookId}")
    public ResponseEntity<List<StudentResponse>> getReadersForBook(@PathVariable Integer bookId) {
        List<StudentResponse> readers = bookService.getReadersForBook(bookId);
        return new ResponseEntity<>(readers, HttpStatus.OK);
    }




}