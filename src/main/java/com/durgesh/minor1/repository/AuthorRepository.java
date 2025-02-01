package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.durgesh.minor1.model.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer> {
    
    // @Query(value = "select * from author where email =:email", nativeQuery = true)
    // Author geAuthor(@Param("email") String email);  - > mysql will run this query in the database 

    // @Query("SELECT a FROM Author a WHERE a.email = :email")
    // Author getAuthor(@Param("email") String email); // -- > hibernate will run this query 


    Author findByEmail(String email);  // --> hibernate will automatically create query
}
