package com.example.demo;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@Validated
public class StudentController {

    // POST 方法
    // 限制 create 方法只能使用 POST 來請求該 url 路徑
    // 等同於 @RequestMapping(value = "/students", method = RequestMethod.POST)
    @PostMapping("/students")
    public String create(@RequestBody @Valid Student student) {
        return "執行資料庫的 Create 操作";
    }

    // GET 方法
    @GetMapping("/students/{studentId}")
    public String read(@PathVariable @Min(100) Integer studentId) {
        return "執行資料庫的 Read 操作";
    }

    // PUT 方法：需告訴後端要更新的 student id 也要把 student 要更新的資訊放 request body 傳遞
    @PutMapping("/students/{studentId}")
    public String update(@PathVariable Integer studentId,
                         @RequestBody Student student) {
        return "執行資料庫的 Update 操作";
    }

    // DELETE 方法
    @DeleteMapping("/students/{studentId}")
    public String delete(@PathVariable Integer studentId) {
        return "執行資料庫的 Delete 操作";
    }
}