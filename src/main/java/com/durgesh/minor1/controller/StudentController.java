package com.durgesh.minor1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durgesh.minor1.model.Book;
import com.durgesh.minor1.model.Student;
import com.durgesh.minor1.request.BookCreateRequest;
import com.durgesh.minor1.request.StudentCreateRequest;
import com.durgesh.minor1.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @PostMapping("/create")
    public Student createBook(@RequestBody StudentCreateRequest studentCreateRequest) {
        return studentService.createStudent(studentCreateRequest);   
    }
}
