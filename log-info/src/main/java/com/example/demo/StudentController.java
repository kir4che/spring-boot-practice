package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);

        return "執行資料庫的 Create 操作";
    }

    @PutMapping("/students/{id}")
    public String update(@PathVariable Integer id,
                         @RequestBody Student student) {

        Student st = studentRepository.findById(id).orElse(null);

        if (st != null) {
            st.setName(student.getName());
            studentRepository.save(st);

            return "執行資料庫的 Update 操作";
        } else return "Update 失敗，數據不存在！";
    }

    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Integer id) {

        studentRepository.deleteById(id);

        return "執行資料庫的 Delete 操作";
    }

    @GetMapping("/students/{id}")
    public Student read(@PathVariable Integer id) {

        log.info("取得 student {}", id);

        Student student = studentRepository.findById(id).orElse(null);

        return student;
    }
}
