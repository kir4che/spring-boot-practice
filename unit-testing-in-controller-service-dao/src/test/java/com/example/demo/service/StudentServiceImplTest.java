package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    @Transactional
    public void insert() {
        Student student = new Student();
        student.setName("Kevin");
        student.setScore(66.2);
        student.setGraduate(true);

        Integer id = studentDao.insert(student);

        Student result = studentDao.getById(id);
        assertNotNull(result);
        assertEquals("Kevin", result.getName());
        assertEquals(66.2, result.getScore());
        assertTrue(result.isGraduate());
        assertNotNull(result.getCreateDate());
    }

    @Test
    @Transactional
    public void update() {
        Student student = studentDao.getById(3);
        student.setName("John");

        studentDao.update(student);


        Student result = studentDao.getById(3);
        assertNotNull(result);
        assertEquals("John", result.getName());
    }
}