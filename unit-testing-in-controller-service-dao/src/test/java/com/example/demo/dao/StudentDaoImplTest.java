package com.example.demo.dao;

import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentDaoImplTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void getById() {
        Student student = studentDao.getById(1);
        assertNotNull(student);
        assertEquals("Amy", student.getName());
        assertEquals(90.3, student.getScore());
        assertTrue(student.isGraduate());
        assertNotNull(student.getCreateDate());
    }

    @Test
    @Transactional
    public void deleteById() {
        // 驗證 deleteById 是否成功刪除 student id = 1 的這筆數據
        studentDao.deleteById(3);

        Student student = studentDao.getById(3);
        // 這筆數據已被刪除，理論上要為 null。
        assertNull(student);
    }
}