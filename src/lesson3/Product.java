package lesson3;

import java.time.LocalDate;

public class Product {
    String name;
    LocalDate productionDate;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void displayInfo() {
        System.out.println("Название: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Статус бронирования: " + (isReserved ? "Забронирован" : "Доступен для заказа"));
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 12, 15);

        Product product1 = new Product(
                "Туалетная вода Dolce & Gabbana Light Blue",
                date,
                "Shiseido",
                "Италия",
                5937,
                true
        );
        product1.displayInfo();
    }
}