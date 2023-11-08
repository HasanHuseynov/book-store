package com.example.bookstore.dto.response;

import com.example.bookstore.dto.response.bidirectional.AuthorResp;
import com.example.bookstore.dto.response.bidirectional.StudentResp;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private Integer bookId;
    private String name;
    private AuthorResp author;
    private List<StudentResp> students;

}
