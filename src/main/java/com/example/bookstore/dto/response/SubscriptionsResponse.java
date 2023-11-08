package com.example.bookstore.dto.response;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionsResponse {
    private Integer subscriptionId;
}
