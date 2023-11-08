package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.UserRequest;
import com.example.bookstore.dto.response.UserResponse;
import com.example.bookstore.entity.User;
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
public interface UserMapper {
    User fromDTO(UserRequest authorRequest);

    UserResponse toDTO(User user);

    List<UserResponse> toDTOs(List<User> users);

    void mapUpdateRequestToEntity(@MappingTarget User user, UserRequest userRequest);
}
