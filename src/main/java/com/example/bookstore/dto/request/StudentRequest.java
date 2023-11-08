package com.example.bookstore.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private Integer studentId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "Age cannot be null")
    private Integer age;
}
