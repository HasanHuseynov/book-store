package com.example.bookstore.controller;

import com.example.bookstore.dto.request.StudentRequest;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.entity.Student;
import com.example.bookstore.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/student"})
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentResponse>> getALlStudent() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable Integer id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @PostMapping
    public ResponseEntity<StudentResponse> createNewStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.createStudent(studentRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteStudent(@Valid @PathVariable Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateStudent(@Valid @PathVariable Integer id, @Valid @RequestBody StudentRequest studentRequest) {
        studentService.updateStudent(id, studentRequest);
        return ResponseEntity.ok("Student updated successfully!");
    }





}