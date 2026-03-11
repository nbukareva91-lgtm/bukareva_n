package lesson4;

interface Shape {
    String getFillColor();
    String getBorderColor();
    String getShapeName();
    double getPerimeter();
    double getArea();

    default void printInfo() {
        System.out.println(getShapeName() + ":");
        System.out.println("  Периметр: " + getPerimeter());
        System.out.println("  Площадь: " + getArea());
        System.out.println("  Цвет заливки: " + getFillColor());
        System.out.println("  Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
