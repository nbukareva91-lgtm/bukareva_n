package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CompareNumbersTestNG {

    private CompareNumbers compareNumbers = new CompareNumbers();

    @Test
    public void testGreaterPositive() {
        assertEquals("Число 5 больше числа 3", compareNumbers.compare(5, 3));
    }

    @Test
    public void testGreaterWithZero() {
        assertEquals("Число 5 больше числа 0", compareNumbers.compare(5, 0));
    }

    @Test
    public void testGreaterWithNegative() {
        assertEquals("Число -1 меньше числа -5", compareNumbers.compare(-1, -5));
    }

    @Test
    public void testLessPositive() {
        assertEquals("Число 3 меньше числа 8", compareNumbers.compare(3, 8));
    }

    @Test
    public void testLessWithZero() {
        assertEquals("Число 0 меньше числа 5", compareNumbers.compare(0, 5));
    }

    @Test
    public void testLessWithNegative() {
        assertEquals("Число -10 меньше числа -5", compareNumbers.compare(-10, -5));
    }

    @Test
    public void testEqualPositive() {
        assertEquals("Число 7 равно числу 7", compareNumbers.compare(7, 7));
    }

    @Test
    public void testEqualNegative() {
        assertEquals("Число -5 равно числу -5", compareNumbers.compare(-5, -5));
    }
}

