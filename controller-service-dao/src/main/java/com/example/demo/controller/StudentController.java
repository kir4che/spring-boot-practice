package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/students/{id}")
    public Student select(@PathVariable Integer id) {
       return studentService.getById(id);
    }
}
