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
public class StudentResponse {
    private Integer studentId;
    private String name;
    private Integer age;
    private List<SubscriptionsResponse> subscriptions;

    private  List<BookResponse> book;

}
