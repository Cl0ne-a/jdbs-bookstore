package com.example.jdbsbookstore.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class Genre implements Serializable {
    private long id;
    private String genre;
}
