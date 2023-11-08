package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.StudentRequest;
import com.example.bookstore.dto.response.StudentResponse;
import com.example.bookstore.entity.Student;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface StudentMapper {
    Student fromDTO(StudentRequest studentRequest);

    StudentResponse toDTO(Student student);

    List<StudentResponse> toDTOs(List<Student> students);

    void mapUpdateRequestToEntity(@MappingTarget Student student, StudentRequest studentRequest);
}
