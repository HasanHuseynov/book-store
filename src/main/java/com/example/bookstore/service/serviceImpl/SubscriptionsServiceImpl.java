package com.example.bookstore.service.serviceImpl;

import com.example.bookstore.exception.NotDataFound;
import com.example.bookstore.dto.request.SubscriptionsRequest;
import com.example.bookstore.dto.response.SubscriptionsResponse;
import com.example.bookstore.entity.Subscriptions;
import com.example.bookstore.mapper.SubscriptionsMapper;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.StudentRepository;
import com.example.bookstore.repository.SubscriptionsRepository;
import com.example.bookstore.service.SubscriptionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionsServiceImpl implements SubscriptionsService {
    private final SubscriptionsRepository subscriptionsRepository;
    private final StudentRepository studentRepository;
    private final AuthorRepository authorRepository;
    private final SubscriptionsMapper subscriptionsMapper;

    @Override
    public List<SubscriptionsResponse> getAllSubscriptions() {
        List<Subscriptions> subscriptionsEntity = subscriptionsRepository.findAll();
        log.info("Inside of subscriptions getAll");
        return subscriptionsMapper.toDTOs(subscriptionsEntity);

    }

    @Override
    public SubscriptionsResponse createSubscription(SubscriptionsRequest subscriptionsRequest) {
        Subscriptions subscriptionsEntity = subscriptionsMapper.fromDTO(subscriptionsRequest);
        subscriptionsEntity = subscriptionsRepository.save(subscriptionsEntity);
        return subscriptionsMapper.toDTO(subscriptionsEntity);
    }

    @Override
    public void deleteById(Integer id) {
        Subscriptions subscriptionsEntity = subscriptionsRepository.findById(id).orElseThrow(() -> {
            return new NotDataFound("Not data found");
        });
        subscriptionsRepository.delete(subscriptionsEntity);
    }

    @Override
    public void updateSubscription(Integer id, SubscriptionsRequest subscriptionsRequest) {
        var subscriptionsEntity = subscriptionsRepository.findById(id).orElseThrow(() -> new NotDataFound("Data not found"));
        subscriptionsMapper.mapUpdateRequestToEntity(subscriptionsEntity, subscriptionsRequest);
        subscriptionsRepository.save(subscriptionsEntity);

    }

    @Override
    public SubscriptionsResponse subscribeToAuthor(Integer studentId, Integer authorId) {
        var subscriptionEntity = new Subscriptions();
        var studentEntity = studentRepository.findById(studentId).orElseThrow(() -> new NotDataFound("Student not found!"));
        var authorEntity = authorRepository.findById(authorId).orElseThrow(() -> new NotDataFound("Author not found!"));
        if (studentEntity != null || authorEntity != null) {
            subscriptionEntity.setStudent(studentEntity);
            subscriptionEntity.setAuthor(authorEntity);
        }
        subscriptionsRepository.save(subscriptionEntity);
        return subscriptionsMapper.toDTO(subscriptionEntity);
    }


}