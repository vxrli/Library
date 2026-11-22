package com.basespringboot.service;

import com.basespringboot.dto.BooksRequest;
import com.basespringboot.dto.BooksResponse;

import java.util.List;

public interface BooksService {

    BooksResponse createBooks(BooksRequest booksRequest);

    BooksResponse getBooksById(Long id);

    List<BooksResponse> getAllBooks();

    List<BooksResponse> searchByTitle(String title);

    List<BooksResponse> searchByAuthor(String author);

    BooksResponse updateBooks(Long id, BooksRequest booksRequest);

    void deleteBooks(Long id);
}