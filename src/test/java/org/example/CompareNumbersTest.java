package org.example;

import org.example.CompareNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CompareNumbersTest {

    private CompareNumbers compareNumbers = new CompareNumbers();

    @Test
    @DisplayName("Первое число больше (положительные)")
    void testGreaterPositive() {
        assertEquals("Число 10 больше числа 5", compareNumbers.compare(10, 5));
    }

    @Test
    @DisplayName("Первое число больше (с нулём и отрицательными)")
    void testGreaterWithZeroAndNegative() {
        assertEquals("Число 5 больше числа 0", compareNumbers.compare(5, 0));
        assertEquals("Число -1 больше числа -5", compareNumbers.compare(-1, -5));
    }

    @Test
    @DisplayName("Первое число меньше (положительные)")
    void testLessPositive() {
        assertEquals("Число 3 меньше числа 8", compareNumbers.compare(3, 8));
    }

    @Test
    @DisplayName("Первое число меньше (с нулём и отрицательными)")
    void testLessWithZeroAndNegative() {
        assertEquals("Число 8 меньше числа 5", compareNumbers.compare(8, 5));
        assertEquals("Число -10 меньше числа -5", compareNumbers.compare(-10, -5));
    }

    @Test
    @DisplayName("Числа равны")
    void testEqual() {
        assertEquals("Число 8 равно числу 7", compareNumbers.compare(7, 7));
        assertEquals("Число 0 равно числу 0", compareNumbers.compare(0, 0));
        assertEquals("Число -5 равно числу -5", compareNumbers.compare(-5, -5));
    }
}
