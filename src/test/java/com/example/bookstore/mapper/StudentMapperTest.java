package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.StudentRequest;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    public void setUp() {
        studentMapper = Mappers.getMapper(StudentMapper.class);
    }

    @Test
    public void testStudentRequestToStudent() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setName("Hasan");
        studentRequest.setAge(30);

        Student student = studentMapper.fromDTO(studentRequest);

        assertThat(student).isNotNull();
        assertThat(student.getName()).isEqualTo(studentRequest.getName());
        assertThat(student.getAge()).isEqualTo(studentRequest.getAge());
    }

    @Test
    public void testStudentToStudentResponse() {
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Hasan");
        student.setAge(40);

        StudentResponse studentResponse = studentMapper.toDTO(student);

        assertThat(studentResponse).isNotNull();
        assertThat(studentResponse.getStudentId()).isEqualTo(student.getStudentId());
        assertThat(studentResponse.getName()).isEqualTo(student.getName());
        assertThat(studentResponse.getAge()).isEqualTo(student.getAge());
    }

    @Test
    public void testToDTOs() {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student();
        student1.setStudentId(1);
        student1.setName("Hasan");
        student1.setAge(30);
        Student student2 = new Student();
        student2.setStudentId(2);
        student2.setName("Ali");
        student2.setAge(40);
        students.add(student1);
        students.add(student2);
        List<StudentResponse> studentResponses = studentMapper.toDTOs(students);
        assertThat(studentResponses).isNotNull();
        assertThat(studentResponses).hasSize(2);
        assertThat(studentResponses.get(0).getStudentId()).isEqualTo(student1.getStudentId());
        assertThat(studentResponses.get(0).getName()).isEqualTo(student1.getName());
        assertThat(studentResponses.get(0).getAge()).isEqualTo(student1.getAge());
        assertThat(studentResponses.get(1).getStudentId()).isEqualTo(student2.getStudentId());
        assertThat(studentResponses.get(1).getName()).isEqualTo(student2.getName());
        assertThat(studentResponses.get(1).getAge()).isEqualTo(student2.getAge());
    }

    @Test
    public void testMapUpdateRequestToEntity() {
        StudentRequest studentRequest = new StudentRequest();
        studentRequest.setName("Updated Name");
        studentRequest.setAge(35);
        Student student = new Student();
        student.setStudentId(1);
        student.setName("Original Name");
        student.setAge(30);
        studentMapper.mapUpdateRequestToEntity(student, studentRequest);
        assertThat(student.getName()).isEqualTo(studentRequest.getName());
        assertThat(student.getAge()).isEqualTo(studentRequest.getAge());
    }

}
