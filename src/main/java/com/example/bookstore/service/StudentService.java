package com.example.bookstore.service;

import com.example.bookstore.dto.request.StudentRequest;
import com.example.bookstore.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Integer id);
    void deleteById(Integer id);
    StudentResponse createStudent(StudentRequest studentRequest);
    void updateStudent(Integer id, StudentRequest studentRequest);


}
