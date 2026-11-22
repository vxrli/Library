package com.basespringboot.controller;

import com.basespringboot.dto.BooksRequest;
import com.basespringboot.dto.BooksResponse;
import com.basespringboot.service.BooksService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BooksResponse createBook(@Valid @RequestBody BooksRequest booksRequest) {
        return booksService.createBooks(booksRequest);
    }

    @GetMapping("/{id}")
    public BooksResponse getBookById(@PathVariable Long id) {
        return booksService.getBooksById(id);
    }

    @GetMapping
    public List<BooksResponse> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/search/title")
    public List<BooksResponse> searchByTitre(@RequestParam String title) {
        return booksService.searchByTitle(title);
    }

    @GetMapping("/search/author")
    public List<BooksResponse> searchByAuthor(@RequestParam String author) {
        return booksService.searchByAuthor(author);
    }

    @PutMapping("/{id}")
    public BooksResponse updateBook(@PathVariable Long id, @Valid @RequestBody BooksRequest booksRequest) {
        return booksService.updateBooks(id, booksRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        booksService.deleteBooks(id);
    }
}