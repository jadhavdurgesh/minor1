package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.durgesh.minor1.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    // 1st way of writing query Native Query (SQL)
    // @Query(value = "select * from author where email = :email", nativeQuery = true) //mysql 

    // 2nd way of writing query JPQL (Java Persistence Query Language)
    // @Query("select a from Author a where a.email=:email") 

    // 3rd way of writing query which is handled by hibernate itself || Derived Query
    // (Method Query)
    Author findByEmail(String email);
}
