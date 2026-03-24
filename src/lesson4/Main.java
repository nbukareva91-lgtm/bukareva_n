package lesson4;

public class Main {
    public static void main(String[] args) {
        Dog dogСhapa = new Dog("Чапа");
        Dog dogRex = new Dog("Рекс");

        Cat[] cats = {
                new Cat("Персик"),
                new Cat("Барсик"),
                new Cat("Ева")
        };

        Bowl bowl = new Bowl(30);

        System.out.println("Собаки:");
        dogСhapa.run(400);
        dogСhapa.swim(15);
        dogRex.run(600);
        dogRex.swim(5);

        System.out.println("\nКоты:");
        for (Cat cat : cats) {
            int runDistance = (int)(Math.random() * 301);
            int swimDistance = (int)(Math.random() * 301);
            cat.run(runDistance);
            cat.swim(swimDistance);
        }
        System.out.println("\nВсего создано животных: " + Animal.getAnimalCount());
        System.out.println("Из них:");
        System.out.println("  Собак: " + Dog.getDogCount());
        System.out.println("  Котов: " + Cat.getCatCount());
        System.out.println("\nЕды в миске: " + bowl.getFoodAmount());
        int[] appetites = {15, 10, 20};
        System.out.println("\nПервое кормление:");
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, appetites[i]);
        }
        System.out.println("\nСостояние котов после первого кормления:");
        for (Cat cat : cats) {
            System.out.println(cat.getFullStatus());
        }
        System.out.println();
        bowl.addFood(20);
        System.out.println();
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl, appetites[i]);
        }
        System.out.println("\nФинальное состояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getFullStatus());
        }
        System.out.println();
        Shape[] shapes = {
                new Circle(7, "Розовый", "Черный"),
                new Rectangle(3, 9, "Зеленый", "Красный"),
                new Triangle(2, 5, 6, "Оранжевый", "Синий")
        };
        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}
