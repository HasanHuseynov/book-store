package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.UserRequest;
import com.example.bookstore.dto.response.UserResponse;
import com.example.bookstore.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class UserMapperTest {

    private UserMapper userMapper;

    @BeforeEach
    public void setUp() {
        userMapper = Mappers.getMapper(UserMapper.class);
    }

    @Test
    public void testUserRequestToUser() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail("hesenhuseynov372@gmail.com");
        userRequest.setUserId(1);

        User user = userMapper.fromDTO(userRequest);

        assertThat(user).isNotNull();
        assertThat(user.getEmail()).isEqualTo(userRequest.getEmail());
        assertThat(user.getUserId() == userRequest.getUserId());
    }

    @Test
    public void testUserToUserResponse() {
        User user = new User();
        user.setUserId(1);
        user.setEmail("hesemhuseynov372@gmail.com");


        UserResponse userResponse = userMapper.toDTO(user);

        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getUserId()).isEqualTo(user.getUserId());
    }

}
