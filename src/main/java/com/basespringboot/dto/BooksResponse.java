package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class BooksResponse {

    private Long id;
    private String title;
    private String author;
    private LocalDate publicationDate;
    private String isbn;
    private Integer stock;
}
