package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.exception.NotDataFound;
import com.example.bookstore.dto.request.StudentRequest;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.entity.Student;
import com.example.bookstore.mapper.StudentMapper;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.StudentRepository;
import com.example.bookstore.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> studentEntity = studentRepository.findAll();
        log.info("Inside of student getAll");
        return studentMapper.toDTOs(studentEntity);

    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student studentEntity = studentMapper.fromDTO(studentRequest);
        studentEntity = studentRepository.save(studentEntity);
        return studentMapper.toDTO(studentEntity);
    }

    @Override
    public void deleteById(Integer id) {
        Student studentEntity = studentRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        studentRepository.delete(studentEntity);
    }

    @Override
    public void updateStudent(Integer id, StudentRequest studentRequest) {
        var studentEntity = studentRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        studentMapper.mapUpdateRequestToEntity(studentEntity, studentRequest);
        studentRepository.save(studentEntity);
    }







}