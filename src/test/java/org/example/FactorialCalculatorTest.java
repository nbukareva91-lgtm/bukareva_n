package org.example;

import org.example.FactorialCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    private FactorialCalculator calculator = new FactorialCalculator();

    @Test
    @DisplayName("Факториал 0")
    void testFactorialZero() {
        assertEquals(1, calculator.factorialIterative(0));
    }

    @Test
    @DisplayName("Факториал 1")
    void testFactorialOne() {
        assertEquals(1, calculator.factorialIterative(1));
    }

    @Test
    @DisplayName("Факториал 2")
    void testFactorialTwo() {
        assertEquals(3, calculator.factorialIterative(2));
    }

    @Test
    @DisplayName("Факториал отрицательного числа выбрасывает исключение")
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorialIterative(-5);
        });
    }
}
