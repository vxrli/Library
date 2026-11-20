  package com.basespringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(length = 100)
    private String author;

    @Column(name = "publication_date", length = 10)
    private Date publicationDate;

    @Column(unique = true, length = 13)
    private String isbn;

    @Column(nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loans> loans;

    public Books() {}

    public Books(String title, String author, Date publicationDate, String isbn, Integer stock) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.stock = stock;
    }
}