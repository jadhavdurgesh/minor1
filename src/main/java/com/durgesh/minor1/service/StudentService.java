package com.durgesh.minor1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.Operator;
import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.model.StudentFilterType;
import com.durgesh.minor1.repository.StudentRepository;
import com.durgesh.minor1.request.StudentCreateRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(StudentCreateRequest studentCreateRequest) {
        List<Student> studentList = studentRepository.findByPhoneNo(studentCreateRequest.getPhoneNo());
        Student studentFromDb = null;
        if (studentList == null || studentList.isEmpty()) {
            studentFromDb = studentRepository.save(studentCreateRequest.toStudent());
        }
        studentFromDb = studentList.get(0);
        return studentFromDb;
    }

    public List<Student> filter(StudentFilterType filterBy, Operator operator, String value) {
        switch (operator) {
            case EQUALS:
                switch (filterBy) {
                    case CONTACT:
                        return studentRepository.findByPhoneNo(value);
                }
            default:
                return new ArrayList<>();
        }
    }
}
