package com.example.bookstore.repository;

import com.example.bookstore.entity.Subscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionsRepository extends JpaRepository<Subscriptions, Integer> {
}
