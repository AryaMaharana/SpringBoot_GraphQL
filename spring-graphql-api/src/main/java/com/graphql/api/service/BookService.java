package com.graphql.api.service;

import com.graphql.api.entitie.Book;
import com.graphql.api.repository.AuthorRepository;
import com.graphql.api.repository.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repo;

    @Autowired
    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book getBookByBookId(Integer bookId) {
        Book response = new Book();
        Optional<Book> book = repo.findById(bookId);

        if (book.isPresent()) {
            response = book.get();
        }
        return response;
    }

    public List<Book> getAllBooks() {
        List<Book> response = new ArrayList<>();
        List<Book> book = repo.findAll();

        if (!CollectionUtils.isEmpty(book)) {
            response = book;
        }
        return response;
    }

    public List<Book> getBookByAuthorId(Integer authorId){
        return repo.findByAuthorAuthorId(authorId);
    }
}
