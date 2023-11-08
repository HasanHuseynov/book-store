package com.example.bookstore.repository;

import com.example.bookstore.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("SELECT s FROM Student s WHERE s.book.bookId = :bookId")
    List<Student> findStudentsByBookId(@Param("bookId") Integer bookId);
}
