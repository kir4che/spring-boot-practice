package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/test")
    public String test() {
        // 非檢查型錯誤
        throw new RuntimeException("test error");
    }

    @RequestMapping("/test2")
    public String test2() {
        // 參數類型不正確
        throw new IllegalArgumentException("test2 error");
    }
}


