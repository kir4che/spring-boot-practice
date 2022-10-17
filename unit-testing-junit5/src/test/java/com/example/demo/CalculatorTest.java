package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Disabled
    @Test
    public void add() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);

        // 檢查 result 是否為 3
        assertEquals(3, result);

        assertNull(result);
        assertTrue(result > 1);
    }

    @DisplayName("測試除法問題")
    @Test
    public void divide() {
        Calculator calculator = new Calculator();

        // 除以 0 則噴出 ArithmeticException
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }
}