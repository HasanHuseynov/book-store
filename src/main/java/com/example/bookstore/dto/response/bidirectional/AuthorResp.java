package com.example.bookstore.dto.response.bidirectional;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResp {
    private Integer authorId;
    private String name;
    private Integer age;
}
