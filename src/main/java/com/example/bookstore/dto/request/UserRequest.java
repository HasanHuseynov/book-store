package com.example.bookstore.dto.request;

import jakarta.validation.constraints.Email;
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
public class UserRequest {

    private Integer userId;
    @NotNull(message = "Password cannot be null")
    private String password;
    @Email
    @NotNull(message = "Email cannot be null")
    private String email;
    @NotNull(message = "Role cannot be null")
    private String role;
}
