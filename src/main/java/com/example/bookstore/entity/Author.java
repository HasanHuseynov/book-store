package com.example.bookstore.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        name = "author",
        schema = "book_store"
)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Subscriptions> subscriptions;



}
