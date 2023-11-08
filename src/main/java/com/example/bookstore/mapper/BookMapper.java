package com.example.bookstore.mapper;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.entity.Book;
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
public interface BookMapper {
    Book fromDTO(BookRequest bookRequest);

    BookResponse toDTO(Book book);

    List<BookResponse> toDTOs(List<Book> books);

    void mapUpdateRequestToEntity(@MappingTarget Book book, BookRequest bookRequest);
}
