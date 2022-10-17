package com.example.demo;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 把 HpPrinter 改由 Spring 容器所管理的 bean
@Component("myPrinter")
public class HpPrinter implements Printer {

//    @Value("${printer.name}")
//    private String name;

//    @Value("${printer.count:10}")
//    private int count;

    @Override
    public void print(String message) {
//        count--;
//        System.out.println(name + "：" + message);
//        System.out.println("剩餘使用次數 " + count);
        System.out.println("HP Printer：" + message);
    }
}