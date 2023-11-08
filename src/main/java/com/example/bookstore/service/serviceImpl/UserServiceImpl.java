package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.exception.NotDataFound;
import com.example.bookstore.dto.request.UserRequest;
import com.example.bookstore.dto.response.UserResponse;
import com.example.bookstore.entity.User;
import com.example.bookstore.mapper.UserMapper;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> userEntity = userRepository.findAll();
        log.info("Inside of user getAll");
        return userMapper.toDTOs(userEntity);

    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User userEntity = userMapper.fromDTO(userRequest);
        userEntity = userRepository.save(userEntity);
        return userMapper.toDTO(userEntity);
    }

    @Override
    public void deleteById(Integer id) {
        User userEntity = userRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        userRepository.delete(userEntity);
    }

    @Override
    public void updateUser(Integer id, UserRequest userRequest) {
        var userEntity = userRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        userMapper.mapUpdateRequestToEntity(userEntity, userRequest);
        userRepository.save(userEntity);

    }
}