package com.example.ch4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    // 若不在 class 上寫 @RequestMapping，可於此寫 @RequestMapping("/detail/product")。
    @RequestMapping("/product")
    public Store product() {
        Store store = new Store();
        List<String> list = new ArrayList<>();
        list.add("蘋果");
        list.add("橘子");
        store.setProductList(list);
        return store;
    }

    @RequestMapping("/user")
    public Student user() {
        Student student = new Student();
        // 這時未設定 id 值則預設為 null
        student.setName("Judy");
        return student;
    }
}
