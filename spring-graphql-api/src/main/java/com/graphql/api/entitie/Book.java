package com.graphql.api.entitie;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_book", schema = "sc_graphql")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String bookName;
    private Integer price;

    @ManyToOne()
    @JoinColumn(name = "authorId")
    private Author author;

}
