package com.basespringboot.entity;

import lombok.NonNull;
import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "members")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull 
    @Column(nullable = false, length = 100)
    private String name;

    @NonNull 
    @Column(nullable = false, length = 100)
    private String firstName;

    @NonNull
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;

    @NonNull 
    @Column(name = "inscription_date", nullable = false, length = 10)
    private Date inscriptionDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Loans> Loans;

}
