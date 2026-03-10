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

        @Override
        public String toString() {
            return "Адрес: " + city + ", ул. " + street + ", д. " + houseNumber;
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

        @Override
        public String toString() {
            return name + "\n" +
                    "  Время работы: " + workingHours + "\n" +
                    "  Стоимость: " + price + " руб.";
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

    @Override
    public String toString() {
        return name + "\n" +
                address.toString() + "\n" +
                "Время работы парка: " + workingHours + "\n";
    }
}
