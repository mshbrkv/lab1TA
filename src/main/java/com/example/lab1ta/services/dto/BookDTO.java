package com.example.lab1ta.services.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publish_date;
    private String publisher;
    private Long pages;
    private String description;
    private String website;
}
