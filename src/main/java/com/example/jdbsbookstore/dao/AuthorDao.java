package com.example.jdbsbookstore.dao;

import com.example.jdbsbookstore.domain.Author;

import java.util.List;

public interface AuthorDao {
    void save(Author author);
    void update(Author author);
    void delete(Author author);
    Author getAuthorById(long id);
    List<Author> getAllAuthors();
}
