package com.basespringboot.repository;

import com.basespringboot.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Optional<Books> findByIsbn(String isbn);

    List<Books> findByTitleContainingIgnoreCase(String title);

    List<Books> findByAuthorContainingIgnoreCase(String author);

    List<Books> findByStockGreaterThan(int stock);
}