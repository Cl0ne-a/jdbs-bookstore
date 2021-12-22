package com.example.jdbsbookstore;

import com.example.jdbsbookstore.dao.BookDao;
import com.example.jdbsbookstore.dao.impl.BookDaoImpl;
import com.example.jdbsbookstore.domain.Author;
import com.example.jdbsbookstore.domain.Book;
import com.example.jdbsbookstore.domain.Genre;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class JdbsBookstoreApplication {

    public static void main(String[] args) throws SQLException {
        var ctx = SpringApplication.run(JdbsBookstoreApplication.class, args);
        BookDao dao = ctx.getBean(BookDaoImpl.class);
        Genre genre = Genre.builder().genre("thriller").build();
        Author author = Author.builder().name("D").build();
        Book book = Book.builder().name("roses in blood").genre(genre).author(author).build();

        dao.save(book);
        dao.getAllBooks().forEach(System.out::println);
        Console.main(args);
    }
}
