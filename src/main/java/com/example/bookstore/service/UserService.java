package com.example.bookstore.service;

import com.example.bookstore.dto.request.UserRequest;
import com.example.bookstore.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    void deleteById(Integer id);
    UserResponse createUser(UserRequest userRequest);
    void updateUser(Integer id, UserRequest userRequest);
}
