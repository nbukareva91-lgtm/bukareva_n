package lesson3;

import java.time.LocalDate;

public class Product {
    private String name;
    private LocalDate productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, LocalDate productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }
    @Override
    public String toString() {
        return "Название: " + name + "\n" +
                "Дата производства: " + productionDate + "\n" +
                "Производитель: " + manufacturer + "\n" +
                "Страна происхождения: " + countryOfOrigin + "\n" +
                "Цена: " + price + " руб.\n" +
                "Статус бронирования: " + (isReserved ? "Забронирован" : "Доступен для заказа");
    }

}