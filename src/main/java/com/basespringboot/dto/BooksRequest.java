package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class BooksRequest {

    @NotBlank(message = "The title is required")
    private String title;

    private String author;

    private LocalDate publicationDate;

    private String isbn;

    @NotNull(message = "The stock is required")
    private Integer stock;
}
