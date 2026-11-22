package com.basespringboot.service;

import com.basespringboot.dto.BooksRequest;
import com.basespringboot.dto.BooksResponse;
import com.basespringboot.entity.Books;
import com.basespringboot.repository.BooksRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;

    public BooksServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    @Transactional
    public BooksResponse createBooks(BooksRequest booksRequest) {
        Books books = new Books();
        books.setTitle(booksRequest.getTitle());
        books.setAuthor(booksRequest.getAuthor());
        books.setPublicationDate(booksRequest.getPublicationDate());
        books.setIsbn(booksRequest.getIsbn());
        books.setStock(booksRequest.getStock());
        Books savedBooks = booksRepository.save(books);
        return toResponse(savedBooks);
    }

    @Override
    @Transactional(readOnly = true)
    public BooksResponse getBooksById(Long id) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Books not found with id: " + id));
        return toResponse(books);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BooksResponse> getAllBooks() {
        return booksRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BooksResponse> searchByTitle(String title) {
        return booksRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<BooksResponse> searchByAuthor(String author) {
        return booksRepository.findByAuthorContainingIgnoreCase(author).stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public BooksResponse updateBooks(Long id, BooksRequest booksRequest) {
        Books books = booksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Books not found with id: " + id));
        books.setTitle(booksRequest.getTitle());
        books.setAuthor(booksRequest.getAuthor());
        books.setPublicationDate(booksRequest.getPublicationDate());
        books.setIsbn(booksRequest.getIsbn());
        books.setStock(booksRequest.getStock());
        return toResponse(booksRepository.save(books));
    }

    @Override
    @Transactional
    public void deleteBooks(Long id) {
        if (!booksRepository.existsById(id)) {
            throw new RuntimeException("Books not found with id: " + id);
        }
        booksRepository.deleteById(id);
    }

    private BooksResponse toResponse(Books books) {
        return new BooksResponse(
                books.getId(),
                books.getTitle(),
                books.getAuthor(),
                books.getPublicationDate(),
                books.getIsbn(),
                books.getStock()
        );
    }
}