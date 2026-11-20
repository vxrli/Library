package com.basespringboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "membres")
@Getter
@Setter
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(name = "date_inscription", length = 10)
    private Date inscriptionDate;

    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loans> emprunts;

    public Members() {}

    public Members(String name, String firstName, String email, String phone, Date inscriptionDate) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.inscriptionDate = inscriptionDate;
    }
}
