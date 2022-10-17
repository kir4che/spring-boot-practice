package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    // HpPrinter 透過 Java 多型特性向上轉型成 Printer
    @Autowired
    // 指定要拿 HpPrinter
    @Qualifier("myPrinter")
    private Printer printer;

    @RequestMapping("/test")
    public String test() {
        printer.print("Hello World！");
        return "Printer";
    }
}