package com.example.bookstore.dto.request;


import com.example.bookstore.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String name;
    @NotNull(message = "Email cannot be null!")
    private String email;
    @NotNull(message = "Role cannot be null")
    private Role role;
    @NotNull(message = "Password cannot be null!")
    private String password;
}
