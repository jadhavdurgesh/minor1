package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durgesh.minor1.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    
}