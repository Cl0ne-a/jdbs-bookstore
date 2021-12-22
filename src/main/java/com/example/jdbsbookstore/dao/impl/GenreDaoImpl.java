package com.example.jdbsbookstore.dao.impl;

import com.example.jdbsbookstore.dao.GenreDao;
import com.example.jdbsbookstore.domain.Genre;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GenreDaoImpl implements GenreDao {
    @Override
    public List<Genre> getAll() {
        return null;
    }
}
