package lesson6;
import java.util.*;
class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    public void add(String surname, String phone) {
        List<String> phones = directory.get(surname);
        if (phones == null) {
            phones = new ArrayList<>();
            directory.put(surname, phones);
        }
        phones.add(phone);
    }
    public List<String> get(String surname) {
        return directory.getOrDefault(surname, Collections.emptyList());
    }

    public void printAll() {
        if (directory.isEmpty()) {
            System.out.println("Справочник пуст");
            return;
        }
        System.out.println("\nТелефонный справочник");
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (String phone : entry.getValue()) {
                System.out.println("  - " + phone);
            }
        }
    }
}
