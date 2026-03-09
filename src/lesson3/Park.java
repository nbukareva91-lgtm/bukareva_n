package lesson3;

public class Park {
    private String name;
    private Address address;
    private String workingHours;


    public class Address {
        private String city;
        private String street;
        private String houseNumber;

        public Address(String city, String street, String houseNumber) {
            this.city = city;
            this.street = street;
            this.houseNumber = houseNumber;
        }

        public void displayAddress() {
            System.out.println("Адрес: " + city + ", ул. " + street + ", д. " + houseNumber);
        }
    }

    public class Attraction {
        private String name;
        private String workingHours;
        private double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void displayInfo() {
            System.out.println(name);
            System.out.println("  Время работы: " + workingHours);
            System.out.println("  Стоимость: " + price + " руб.");
        }
    }

    public Park(String name, String city, String street, String houseNumber, String workingHours) {
        this.name = name;
        this.address = new Address(city, street, houseNumber);
        this.workingHours = workingHours;
    }

    public Attraction createAttraction(String name, String workingHours, double price) {
        return new Attraction(name, workingHours, price);
    }

    public void displayParkInfo() {
        System.out.println(name);
        address.displayAddress();
        System.out.println("Время работы парка: " + workingHours);
        System.out.println();
    }

    public static void main(String[] args) {
        Park park = new Park(
                "Сочи Парк",
                "пгт Сириус",
                "Олимпийский проспект",
                "21",
                "11:00 - 19:00"
        );

        park.displayParkInfo();

        Park.Attraction attraction1 = park.createAttraction("Вечный двигатель", "11:00 - 19:00", 350.0);
        Park.Attraction attraction2 = park.createAttraction("Чайные чашки", "11:00 - 19:00", 650.0);
        Park.Attraction attraction3 = park.createAttraction("Змей Горыныч", "11:00 - 19:00", 750.0);

        System.out.println("Аттракционы:");
        attraction1.displayInfo();
        attraction2.displayInfo();
        attraction3.displayInfo();
    }
}
