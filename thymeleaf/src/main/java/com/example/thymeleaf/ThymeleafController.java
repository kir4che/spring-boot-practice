package com.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThymeleafController {

    // 對 home 這個 url 路徑發起一個 GET 請求
    @GetMapping("/home")
    public String home(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("Judy");

        // 將 student 變數存放到 Thymeleaf 的 myStudent 變數
        model.addAttribute("myStudent", student);

        return "index";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @PostMapping("/login")
    public String login(String userName,
                        String userPassword) {

        System.out.println("userName 為: " + userName);
        System.out.println("userPassword 為: " + userPassword);

        return "login";
    }
}
