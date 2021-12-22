package com.example.jdbsbookstore.dao.impl;

import com.example.jdbsbookstore.dao.AuthorDao;
import com.example.jdbsbookstore.domain.Author;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {
    @Override
    public void save(Author author) {

    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(Author author) {

    }

    @Override
    public Author getAuthorById(long id) {
        return null;
    }

    @Override
    public List<Author> getAllAuthors() {
        return null;
    }
}
