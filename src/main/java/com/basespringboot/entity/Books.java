  package com.basespringboot.entity;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;
import lombok.NonNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false, length = 255)
    private String title;

    @NonNull 
    @Column(nullable = false, length = 100)
    private String author;

    @NonNull
    @Column(name = "publication_date", length = 10)
    private Date publicationDate;

    @NonNull 
    @Column(unique = true, length = 13)
    private String isbn;

    @NonNull
    @Column(nullable = false)
    private Integer stock;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loans> loans;

}