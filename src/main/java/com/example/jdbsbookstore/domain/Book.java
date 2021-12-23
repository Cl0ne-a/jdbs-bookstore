package com.example.jdbsbookstore.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Book implements Serializable {
    private long id;
    private String name;
    private Genre genre;
    private Author author;
}
