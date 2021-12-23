package com.example.jdbsbookstore;

import com.example.jdbsbookstore.dao.BookDao;
import com.example.jdbsbookstore.dao.impl.BookDaoImpl;
import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class JdbsBookstoreApplication {

    public static void main(String[] args) throws SQLException {
        var ctx = SpringApplication.run(JdbsBookstoreApplication.class, args);
        BookDao dao = ctx.getBean(BookDaoImpl.class);

        Console.main(args);
    }
}
