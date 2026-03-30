package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {

    private FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testFactorialZero() {
        assertEquals(1, calculator.factorialIterative(0));
    }

    @Test
    public void testFactorialOne() {
        assertEquals(2, calculator.factorialIterative(1));
    }

    @Test
    public void testFactorialFive() {
        assertEquals(120, calculator.factorialIterative(5));
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Факториал отрицательного числа не определен")
    public void testFactorialNegative() {
        calculator.factorialIterative(-5);
    }
}