package com.example.jdbsbookstore.dao.impl;

import com.example.jdbsbookstore.dao.BookDao;
import com.example.jdbsbookstore.domain.Author;
import com.example.jdbsbookstore.domain.Book;
import com.example.jdbsbookstore.domain.Genre;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BookDaoImpl implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    public BookDaoImpl(NamedParameterJdbcOperations namedParameterJdbcOperations) {
        this.jdbc = namedParameterJdbcOperations;
    }


    @Override
    public void update(Book book) {
        long id = book.getId();
        jdbc.query(
                "update book set name = :name, genre = :genre, author = :author where id = :id",
                Map.of("id", book.getId(),
                        "name", book.getName(),
                        "genre", book.getGenre().getGenre(),
                        "author", book.getAuthor().getName()),
                new BookMapper());
    }

    @Override
    public void delete(Book book) {
        long id = book.getId();
        jdbc.query(
                "delete from book where id = :id",
                Map.of("id", id),
                new BookMapper());
    }

    @Override
    public Book getBookById(long id) {
        Map<String, Object> map = Collections.singletonMap("id", id);
        return jdbc.queryForObject(
                "select id, name, genre, author from book where id = :id",
                map,
                new BookMapper());
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbc.query(
                "select id, name, genre, author from book",
                new BookMapper());
    }

    @Override
    public List<Book> getByAuthor(Author author) {
        return jdbc.query("select id, name, genre from book where author = :author", new BookMapper());
    }


    @Override
    public void save(Book book) {
        jdbc.update(
                "insert into book values (:id, :name, :genre, :author)",
                Map.of(
                        "id", book.getId(),
                        "name", book.getName(),
                        "genre", book.getGenre(),
                        "author", book.getAuthor())
        );
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            var id = rs.getLong("id");
            var name = rs.getString("name");
            var genre = rs.getObject("genre");
            var author = rs.getObject("author");
            return Book.builder()
                    .id(id)
                    .name(name)
                    .genre((Genre) genre)
                    .author((Author) author).build();
        }
    }
}
