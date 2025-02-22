package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.minor1.model.Book;

import lombok.RequiredArgsConstructor;
@Repository
// @RequiredArgsConstructor
public interface BookRepository extends JpaRepository<Book, Integer>{
    // private final AuthorRepository authorRepository;
}
