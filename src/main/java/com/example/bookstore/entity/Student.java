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
        name = "student",
        schema = "book_store"
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<Subscriptions> subscriptions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private List<Book> books;

}
