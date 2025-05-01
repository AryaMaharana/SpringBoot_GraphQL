package com.graphql.api.service;

import com.graphql.api.entitie.Author;
import com.graphql.api.entitie.Book;
import com.graphql.api.model.CreateBookRequest;
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
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository repo, AuthorRepository authorRepository) {
        this.repo = repo;
        this.authorRepository = authorRepository;
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

    public List<Book> getBookByAuthorId(Integer authorId) {
        return repo.findByAuthorAuthorId(authorId);
    }

    public Book addBooks(CreateBookRequest createBookRequest) {
        Author getAuthorDetails = authorRepository.
                findById(createBookRequest.getAuthorId()).orElseThrow(() -> new RuntimeException("Not found"));
        Book book = new Book();
        book.setBookName(createBookRequest.getBookName());
        book.setPrice(createBookRequest.getPrice());
        book.setAuthor(getAuthorDetails);
        return repo.save(book);
    }
}
