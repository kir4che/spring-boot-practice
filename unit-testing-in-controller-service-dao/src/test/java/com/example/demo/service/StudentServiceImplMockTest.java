package com.example.demo.service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentServiceImplMockTest {

    @Autowired
    private StudentService studentService;

    // 使用一個假的 bean 替換掉 Spring 容器中的 StudentDao bean
    @MockBean
    private StudentDao studentDao;

    @Test
    public void getById() {
        Student mockStudent = new Student();
        mockStudent.setId(100);
        mockStudent.setName("I'm mock");

//        // 指定假的 StudentDao 固定回傳假的 mockStudent
//        // 當有人 call studentDao.getById()，且參數為 3 時，就固定回傳 mockStudent 這個 object
//        Mockito.when(studentDao.getById(3)).thenReturn(mockStudent);

        // 以任何參數來請求 studentDao.getById() 皆固定回傳 mockStudent 出來
        Mockito.when(studentDao.getById(Mockito.any())).thenReturn(mockStudent);

        Student student = studentService.getById(2);
        assertNotNull(student);
        assertEquals(100, student.getId());
        assertEquals("I'm mock", student.getName());
    }
}