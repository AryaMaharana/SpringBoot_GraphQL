package com.graphql.api.controller;

import com.graphql.api.entitie.Book;
import com.graphql.api.model.CreateBookRequest;
import com.graphql.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @QueryMapping
    public Book getBookByBookId(@Argument Integer bookId) {
        return service.getBookByBookId(bookId);
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return service.getAllBooks();
    }

    @QueryMapping
   public List<Book> getBookByAuthorId(@Argument Integer authorId){
        return service.getBookByAuthorId(authorId);
   }

   @MutationMapping
    public Book addBooks(@Argument("input") CreateBookRequest createBookRequest){
       return service.addBooks(createBookRequest);
    }


}
