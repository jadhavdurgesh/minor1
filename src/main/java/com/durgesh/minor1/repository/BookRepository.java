package com.durgesh.minor1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.BookType;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    List<Book> findByBookNo(String bookNo);

    List<Book> findByAuthorName(String authorName);

    List<Book> findByCost(int cost);

    List<Book> findByBookType(BookType bookType);

    List<Book> findByCostLessThan(int cost);
}
