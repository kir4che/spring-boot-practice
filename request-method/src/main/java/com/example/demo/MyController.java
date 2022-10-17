package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @RequestMapping("/test")
    public String test(@RequestParam(defaultValue = "10") Integer id,
                       @RequestParam(defaultValue = "Judy") String name) {
        System.out.println("id：" + id);
        System.out.println("name：" + name);
        return "Hello world！";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody Student student) {
        System.out.println("student id：" + student.getId());
        System.out.println("student name：" + student.getName());
        return "Hello world 2！";
    }

    @RequestMapping("/test3")
    public String test3(@RequestHeader String info) {
        System.out.println("header info：" + info);
        return "Hello world 3！";
    }

    @RequestMapping("/test4/{id}/{name}")
    public String test4(@PathVariable Integer id,
                        @PathVariable String name) {
        System.out.println("path id：" + id);
        System.out.println("path name：" + name);
        return "Hello world 4！";
    }
}