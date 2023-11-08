package com.example.bookstore.dto.response;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResponse {
    private Integer authorId;
    private String name;
    private Integer age;
    private List<BookResponse> book;

    private List<SubscriptionsResponse> subscriptions;
}
