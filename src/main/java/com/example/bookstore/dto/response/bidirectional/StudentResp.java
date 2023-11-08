package com.example.bookstore.dto.response.bidirectional;

import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.dto.response.SubscriptionsResponse;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResp {
    private Integer studentId;
    private String name;
    private Integer age;
    private List<SubscriptionsResponse> subscriptions;


}