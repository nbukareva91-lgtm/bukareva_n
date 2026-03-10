package lesson3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Туалетная вода Calvin Klein CK Everyone", LocalDate.of(2024, 10, 10), "Coty", "США", 3705, true);
        productsArray[1] = new Product("Туалетная вода Dolce & Gabbana Light Blue", LocalDate.of(2025, 1, 10), "Shiseido", "Италия", 5937, false);
        productsArray[2] = new Product("Туалетная вода Escada Fiesta Carioca", LocalDate.of(2024, 12, 15), "Coty", "Германия", 6700, true);
        productsArray[3] = new Product("Туалетная вода Chanel Coco", LocalDate.of(2025, 4, 8), "Chanel", "Франция", 10585, false);
        productsArray[4] = new Product("Парфюмерная вода Tom Ford Tobacco Vanille", LocalDate.of(2025, 2, 22), "Estee Lauder", "США", 14450, true);

        for (int i = 0; i < productsArray.length; i++) {
            System.out.println("\nТовар " + (i + 1) + ":");
            System.out.println(productsArray[i]);
        }

        Park park = new Park(
                "Сочи Парк",
                "пгт Сириус",
                "Олимпийский проспект",
                "21",
                "11:00 - 19:00"
        );
        System.out.println();
        System.out.println(park);

        Park.Attraction attraction1 = park.createAttraction("Вечный двигатель", "11:00 - 19:00", 350.0);
        Park.Attraction attraction2 = park.createAttraction("Чайные чашки", "11:00 - 19:00", 650.0);
        Park.Attraction attraction3 = park.createAttraction("Змей Горыныч", "11:00 - 19:00", 750.0);

        System.out.println("Аттракционы:");
        System.out.println(attraction1);
        System.out.println(attraction2);
        System.out.println(attraction3);
    }
}
