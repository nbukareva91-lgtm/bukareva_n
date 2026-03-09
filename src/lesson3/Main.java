package lesson3;

public class Main {

    static class Product {
        String name;
        int volume;
        String manufacturer;
        String countryOfOrigin;
        double price;
        boolean isReserved;

        public Product(String name, int volume, String manufacturer,
                       String countryOfOrigin, double price, boolean isReserved) {
            this.name = name;
            this.volume = volume;
            this.manufacturer = manufacturer;
            this.countryOfOrigin = countryOfOrigin;
            this.price = price;
            this.isReserved = isReserved;
        }

        public String getReservationStatus() {
            if (isReserved) {
                return "забронирован";
            } else {
                return "доступен для заказа";
            }
        }

        public void displayInfo() {
            System.out.println("Название товара: " + name);
            System.out.println("Объем: " + volume + " мл");
            System.out.println("Производитель: " + manufacturer);
            System.out.println("Страна происхождения: " + countryOfOrigin);
            System.out.println("Цена: " + price + " руб.");
            System.out.println("Статус бронирования: " + getReservationStatus());
        }
    }

    public static void main(String[] args) {
        // Создаем массив из 5 товаров
        Product[] productsArray = {
                new Product("Туалетная вода Calvin Klein CK Everyone", 50, "Coty", "США", 3705, true),
                new Product("Туалетная вода Dolce & Gabbana Light Blue", 30, "Shiseido", "Италия", 5937, false),
                new Product("Туалетная вода Escada Fiesta Carioca", 50, "Coty", "Германия", 6700, true),
                new Product("Туалетная вода Chanel Coco", 50, "Chanel", "Франция", 10585, false),
                new Product("Парфюмерная вода Tom Ford Tobacco Vanille", 30, "Estee Lauder", "США", 14450, true)
        };

        // Выводим информацию обо всех товарах
        for (int i = 0; i < productsArray.length; i++) {
            System.out.println();
            System.out.println("Товар " + (i + 1) + ":");
            productsArray[i].displayInfo();
        }
    }
}
