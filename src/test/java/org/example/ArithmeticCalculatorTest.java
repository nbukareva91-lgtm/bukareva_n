package org.example;

import org.example.ArithmeticCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticCalculatorTest {

    private ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Test
    @DisplayName("Сложение положительных чисел")
    void testAddPositive() {
        assertEquals(10, calculator.add(4, 6));
    }

    @Test
    @DisplayName("Сложение отрицательных чисел")
    void testAddNegative() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 2, 3",
            "2, 5, -4",
            "0, 5, -5",
            "-5, -3, -2"
    })
    @DisplayName("Параметризованный тест вычитания")
    void testSubtractParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    @Test
    @DisplayName("Умножение положительных чисел")
    void testMultiplyPositive() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    @DisplayName("Умножение отрицательных чисел")
    void testMultiplyNegative() {
        assertEquals(-15, calculator.multiply(-3, 5));
    }

    @Test
    @DisplayName("Деление положительных чисел")
    void testDividePositive() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test
    @DisplayName("Деление отрицательных чисел")
    void testDivideNegative() {
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001);
    }

    @Test
    @DisplayName("Деление на ноль выбрасывает исключение")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }
}
