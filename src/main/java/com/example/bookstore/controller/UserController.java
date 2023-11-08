package com.example.bookstore.controller;

import com.example.bookstore.dto.request.UserRequest;
import com.example.bookstore.dto.response.UserResponse;
import com.example.bookstore.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/user"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getALlUser() {

        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PostMapping
    public ResponseEntity<UserResponse> createNewUser(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteUser(@Valid @PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateUser(@Valid @PathVariable Integer id, @Valid @RequestBody UserRequest userRequest) {
        userService.updateUser(id, userRequest);
        return ResponseEntity.ok("User updated successfully!");
    }


}