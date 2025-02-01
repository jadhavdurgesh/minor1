package com.durgesh.minor1.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String name;

    @Column(unique = true, length = 30, nullable = false)
    private String email;

    @Column(length = 15 , nullable = true)
    private String phoneNumber;

    private String address;

    @CreationTimestamp
    private Date createOn;

    @UpdateTimestamp
    private Date updateOn;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @OneToMany(mappedBy = "student")
    private List<Book> books;

    @OneToMany(mappedBy = "student")
    private List<Txn> txns;
}
