package com.example.bookstore.controller;

import com.example.bookstore.dto.request.AuthorRequest;
import com.example.bookstore.dto.response.AuthorResponse;
import com.example.bookstore.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/author"})
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getALlAuthor() {

        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @PostMapping
    public ResponseEntity<AuthorResponse> createNewAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(authorService.createAuthor(authorRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteAuthor(@Valid @PathVariable Integer id) {
        authorService.deleteById(id);
        return ResponseEntity.ok("Author deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateAuthor(@Valid @PathVariable Integer id, @Valid @RequestBody AuthorRequest authorRequest) {
        authorService.updateAuthor(id, authorRequest);
        return ResponseEntity.ok("Author updated successfully!");
    }



}
