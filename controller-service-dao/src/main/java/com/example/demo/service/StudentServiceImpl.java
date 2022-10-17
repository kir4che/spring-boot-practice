package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.dao.StudentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDaoImpl studentDao;

    public Student getById(Integer id) {
        return studentDao.getById(id);
    }
}
