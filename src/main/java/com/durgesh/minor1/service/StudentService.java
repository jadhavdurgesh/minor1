package com.durgesh.minor1.service;

import org.springframework.stereotype.Service;

import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.repository.StudentRepository;
import com.durgesh.minor1.request.StudentCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        Student studentFromDb = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        if (studentFromDb == null) {
            studentFromDb = studentRepository.save(studentCreateRequest.toStudent());
        }
        return studentFromDb;
    }
}
