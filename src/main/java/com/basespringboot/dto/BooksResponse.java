package com.basespringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor 
public class BooksResponse {

    private Long id;
    private String title;
    private String author;
    private Date publicationDate;
    private String isbn;
    private Integer stock;
}