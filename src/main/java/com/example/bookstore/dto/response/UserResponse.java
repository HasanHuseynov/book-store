package com.example.bookstore.dto.response;
import com.example.bookstore.dto.response.bidirectional.StudentResp;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {
    private Integer userId;
    private String password;
    private String role;
    private AuthorResponse author;

}
