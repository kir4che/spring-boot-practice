package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // Create 新增：使用 save 新增一筆新的數據到資料庫中
    @PostMapping("/students")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);

        return "執行資料庫的 Create 操作";
    }

    // Update 修改：使用 save 修改資料表中已存在的數據
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

    // Delete 刪除：使用 deleteById 根據 id 刪除資料庫中的數據
    @DeleteMapping("/students/{id}")
    public String delete(@PathVariable Integer id) {

        studentRepository.deleteById(id);

        return "執行資料庫的 Delete 操作";
    }

    // Read 查詢：使用 findById 根據 id 去查詢資料庫中的數據
    @GetMapping("/students/{id}")
    public Student read(@PathVariable Integer id) {

        // findById 回傳一個 Optional 型別的變數
        // orElse(null) 表示在資料庫找不到該筆 student 數據的話，該 student object 值則為 null。
        Student student = studentRepository.findById(id).orElse(null);

        return student;
    }
}
