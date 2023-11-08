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
public class AuthorRequest {

    private Integer authorId;
    @NotNull(message = "Author name cannot be null!")
    private String name;
    private Integer age;
}
