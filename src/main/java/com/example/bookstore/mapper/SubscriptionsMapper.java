package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.SubscriptionsRequest;
import com.example.bookstore.dto.response.SubscriptionsResponse;
import com.example.bookstore.entity.Subscriptions;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true)
)
public interface SubscriptionsMapper {
    Subscriptions fromDTO(SubscriptionsRequest subscriptionsRequest);

    SubscriptionsResponse toDTO(Subscriptions subscriptions);

    List<SubscriptionsResponse> toDTOs(List<Subscriptions> subscriptions);

    void mapUpdateRequestToEntity(@MappingTarget Subscriptions author, SubscriptionsRequest subscriptionsRequest);
}
