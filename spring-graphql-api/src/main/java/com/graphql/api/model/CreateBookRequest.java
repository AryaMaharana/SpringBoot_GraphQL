package com.graphql.api.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

public class CreateBookRequest implements Serializable {

    private Integer bookId;
    private String bookName;
    private Integer price;
    private Integer authorId;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CreateBookRequest that)) return false;
        return Objects.equals(getBookId(), that.getBookId()) && Objects.equals(getBookName(), that.getBookName()) && Objects.equals(getPrice(), that.getPrice()) && Objects.equals(getAuthorId(), that.getAuthorId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookId(), getBookName(), getPrice(), getAuthorId());
    }

    @Override
    public String toString() {
        return "CreateBookRequest{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", authorId=" + authorId +
                '}';
    }
}
