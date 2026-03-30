package org.example;

import org.example.TriangleArea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaTest {

    private TriangleArea triangleArea = new TriangleArea();

    @Test
    @DisplayName("Площадь треугольника: основание 10, высота 5")
    void testAreaTenAndFive() {
        assertEquals(25.0, triangleArea.areaByBaseAndHeight(10, 5));
    }

    @Test
    @DisplayName("Площадь треугольника: основание 5.5, высота 4.5")
    void testAreaDouble() {
        assertEquals(13.375, triangleArea.areaByBaseAndHeight(5.5, 4.5), 0.001);
    }

    @Test
    @DisplayName("Исключение на ноль")
    void testAreaBaseZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            triangleArea.areaByBaseAndHeight(0, 5);
        });
    }

    @Test
    @DisplayName("Исключение отрицательное число")
    void testAreaNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> {
            triangleArea.areaByBaseAndHeight(-5, 10);
        });
    }
}
