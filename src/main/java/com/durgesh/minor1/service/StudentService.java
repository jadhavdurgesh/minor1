package com.durgesh.minor1.service;

import org.springframework.stereotype.Service;

import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.request.StudentCreateRequest;

@Service
public class StudentService {

    public Student createStudent(StudentCreateRequest studentCreateRequest) {
       return studentCreateRequest.toStudent();
    }
    
}
