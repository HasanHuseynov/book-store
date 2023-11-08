package com.example.bookstore.mapper;
import com.example.bookstore.dto.request.AuthorRequest;
import com.example.bookstore.dto.response.AuthorResponse;
import com.example.bookstore.entity.Author;
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
public interface AuthorMapper {
    Author fromDTO(AuthorRequest authorRequest);

    AuthorResponse toDTO(Author author);

    List<AuthorResponse> toDTOs(List<Author> authors);

    void mapUpdateRequestToEntity(@MappingTarget Author author, AuthorRequest authorRequest);
}
