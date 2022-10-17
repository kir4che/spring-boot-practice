package com.example.demo;

public class Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public float divide(int x, int y) {
        return x / y;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.add(1, 2);
        System.out.println("結果為：" + result);

        float result2 = calculator.divide(10, 2);
        System.out.println("結果為：" + result2);
    }
}
