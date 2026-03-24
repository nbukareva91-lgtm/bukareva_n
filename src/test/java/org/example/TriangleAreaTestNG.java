package org.example;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaTestNG {

    private TriangleArea triangleArea = new TriangleArea();

    @Test
    public void testAreaPositive() {
        assertEquals(25.0, triangleArea.areaByBaseAndHeight(10, 5));
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Основание и высота должны быть положительными числами")
    public void testAreaBaseZero() {
        triangleArea.areaByBaseAndHeight(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Основание и высота должны быть положительными числами")
    public void testAreaNegativeBase() {
        triangleArea.areaByBaseAndHeight(-5, 10);
    }
}
