package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.SubscriptionsRequest;
import com.example.bookstore.dto.response.SubscriptionsResponse;
import com.example.bookstore.entity.Subscriptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubscriptionsMapperTest {

    private SubscriptionsMapper subscriptionsMapper;

    @BeforeEach
    public void setUp() {
        subscriptionsMapper = Mappers.getMapper(SubscriptionsMapper.class);
    }

    @Test
    public void testSubscriptionsRequestToSubscriptions() {
        SubscriptionsRequest subscriptionsRequest = new SubscriptionsRequest();
        subscriptionsRequest.setSubscriptionId(1);

        Subscriptions subscriptions = subscriptionsMapper.fromDTO(subscriptionsRequest);

        assertThat(subscriptions).isNotNull();
        assertThat(subscriptions.getSubscriptionId() == subscriptionsRequest.getSubscriptionId());

    }

    @Test
    public void testSubscriptionsToSubscriptionsResponse() {
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setSubscriptionId(1);


        SubscriptionsResponse subscriptionsResponse = subscriptionsMapper.toDTO(subscriptions);

        assertThat(subscriptionsResponse).isNotNull();
        assertThat(subscriptionsResponse.getSubscriptionId()).isEqualTo(subscriptions.getSubscriptionId());
    }

    @Test
    public void testToDTOs() {
        List<Subscriptions> subscriptionss = new ArrayList<>();
        Subscriptions subscriptions1 = new Subscriptions();
        subscriptions1.setSubscriptionId(1);

        Subscriptions subscriptions2 = new Subscriptions();
        subscriptions2.setSubscriptionId(2);

        subscriptionss.add(subscriptions1);
        subscriptionss.add(subscriptions2);
        List<SubscriptionsResponse> subscriptionsResponses = subscriptionsMapper.toDTOs(subscriptionss);
        assertThat(subscriptionsResponses).isNotNull();
        assertThat(subscriptionsResponses).hasSize(2);
        assertThat(subscriptionsResponses.get(0).getSubscriptionId()).isEqualTo(subscriptions1.getSubscriptionId());

        assertThat(subscriptionsResponses.get(1).getSubscriptionId()).isEqualTo(subscriptions2.getSubscriptionId());

    }

    @Test
    public void testMapUpdateRequestToEntity() {
        SubscriptionsRequest subscriptionsRequest = new SubscriptionsRequest();
        subscriptionsRequest.setSubscriptionId(1);
        Subscriptions subscriptions = new Subscriptions();
        subscriptions.setSubscriptionId(1);
        subscriptionsMapper.mapUpdateRequestToEntity(subscriptions, subscriptionsRequest);
        assertThat(subscriptions.getSubscriptionId() == subscriptionsRequest.getSubscriptionId());

    }

}
