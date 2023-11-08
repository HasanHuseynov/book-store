package com.example.bookstore.controller;

import com.example.bookstore.dto.request.SubscriptionsRequest;
import com.example.bookstore.dto.response.SubscriptionsResponse;
import com.example.bookstore.service.SubscriptionsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping({"/subscriptions"})
@RequiredArgsConstructor
public class SubscriptionsController {
    private final SubscriptionsService subscriptionsService;

    @GetMapping
    public ResponseEntity<List<SubscriptionsResponse>> getALlSubscriptions() {

        return ResponseEntity.ok(subscriptionsService.getAllSubscriptions());
    }
    @PostMapping
    public ResponseEntity<SubscriptionsResponse> createNewSubscriptions(@Valid @RequestBody SubscriptionsRequest subscriptionsRequest) {
        return ResponseEntity.ok(subscriptionsService.createSubscription(subscriptionsRequest));
    }

    @DeleteMapping({"/id/{id}"})
    public ResponseEntity<String> deleteSubscriptions(@Valid @PathVariable Integer id) {
        subscriptionsService.deleteById(id);
        return ResponseEntity.ok("Subscriptions deleted successfully");
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<String> updateSubscriptions(@Valid @PathVariable Integer id, @Valid @RequestBody SubscriptionsRequest subscriptionsRequest) {
        subscriptionsService.updateSubscription(id, subscriptionsRequest);
        return ResponseEntity.ok("Subscriptions updated successfully!");
    }

    @PostMapping("/subscribe-to-author")
    public ResponseEntity<SubscriptionsResponse> subscribeToAuthor(@RequestParam Integer studentId, @RequestParam Integer authorId) {
        return ResponseEntity.ok(subscriptionsService.subscribeToAuthor(studentId, authorId));
    }


}