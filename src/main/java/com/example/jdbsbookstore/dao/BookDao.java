package com.example.jdbsbookstore.dao;

import com.example.jdbsbookstore.domain.Author;
import com.example.jdbsbookstore.domain.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);
    void update(Book book);
    void delete(Book book);
    Book getBookById(long id);
    List<Book> getAllBooks();
    List<Book> getByAuthor(Author author);
}
