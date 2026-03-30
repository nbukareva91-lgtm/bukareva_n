package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticCalculatorTestNG {

    private ArithmeticCalculator calculator = new ArithmeticCalculator();

    @Test
    public void testAddPositive() {
        assertEquals(10, calculator.add(4, 6));
    }

    @Test
    public void testAddNegative() {
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    public void testSubtractPositive() {
        assertEquals(1, calculator.subtract(5, 5));
    }

    @Test
    public void testSubtractNegative() {
        assertEquals(8, calculator.subtract(5, -3));
    }

    @Test
    public void testMultiplyPositive() {
        assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    public void testMultiplyNegative() {
        assertEquals(-15, calculator.multiply(-3, 5));
    }

    @Test
    public void testDividePositive() {
        assertEquals(2.5, calculator.divide(5, 2), 0.001);
    }

    @Test
    public void testDivideNegative() {
        assertEquals(-2.5, calculator.divide(-5, 2), 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class,
            expectedExceptionsMessageRegExp = "деление на ноль невозможно")
    public void testDivideByZero() {
        calculator.divide(5, 0);
    }
}
