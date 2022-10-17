package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/test")
    public String test() {
        System.out.println("執行 test 方法");
        return "Hello test！";
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println("執行 test 2 方法");
        return "Hello test 2！";
    }
}


