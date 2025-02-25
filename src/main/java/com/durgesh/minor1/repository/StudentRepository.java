package com.durgesh.minor1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.minor1.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByPhoneNo(String phoneNo);
}
