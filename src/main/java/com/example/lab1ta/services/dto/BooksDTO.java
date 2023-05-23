package com.example.lab1ta.services.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class BooksDTO implements Serializable {
    private List<BookDTO> books;
}
