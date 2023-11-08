package com.example.bookstore.service;

import com.example.bookstore.dto.request.SubscriptionsRequest;
import com.example.bookstore.dto.response.SubscriptionsResponse;

import java.util.List;

public interface SubscriptionsService {
    List<SubscriptionsResponse> getAllSubscriptions();
    void deleteById(Integer id);
    SubscriptionsResponse createSubscription(SubscriptionsRequest subscriptionsRequest);
    void updateSubscription(Integer id, SubscriptionsRequest subscriptionsRequest);
    SubscriptionsResponse subscribeToAuthor(Integer studentId, Integer authorId);
}
