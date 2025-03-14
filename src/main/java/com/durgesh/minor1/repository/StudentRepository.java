package com.durgesh.minor1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.minor1.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByPhoneNo(String phoneNo);
}
