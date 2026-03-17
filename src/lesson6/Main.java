package lesson6;
import java.util.*;
class Main {

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на " + course + " курсе:");
        int count = 0;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  - " + student.getName());
                count++;
            }
        }
        if (count == 0) {
            System.out.println("  (нет студентов на данном курсе)");
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Локтев Андрей", "БЭ-81", 2, Arrays.asList(5, 4, 3, 5)));
        students.add(new Student("Сахаров Михаил", "БЭ-81", 2, Arrays.asList(2, 3, 2, 4)));
        students.add(new Student("Самойлова Анна", "БЭ-83", 3, Arrays.asList(4, 4, 5, 5)));
        students.add(new Student("Никифоров Александр", "БЭ-83", 3, Arrays.asList(3, 3, 4, 3)));
        students.add(new Student("Васильева Наталья", "БЭ-81", 1, Arrays.asList(5, 5, 5, 4)));
        students.add(new Student("Перевозчиков Дмитрий", "БЭ-84", 4, Arrays.asList(2, 2, 3, 2)));
        System.out.println(" Все студенты:");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n Отчисленные студенты:");
        for (Student s : students) {
            if (s.getAverageGrade() < 3.0) {
                System.out.println(s);
            }
        }
        StudentManager.deleteStudents(students);

        System.out.println("\n Переведены на следующий курс:");
        StudentManager.promoteStudents(students);
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println("\n Студенты обучающиеся на курсе:");
        printStudents(students, 2);
        System.out.println();
        printStudents(students, 3);
        System.out.println();
        printStudents(students, 4);

        PhoneDirectory directory = new PhoneDirectory();
        directory.add("Павлов", "+7 (913) 123 45 67");
        directory.add("Волков", "+7 (911) 456 78 90");
        directory.add("Павлов", "+7 (921) 678 90 12");
        directory.add("Васильев", "+7 (955) 667 78 89");
        directory.add("Волков", "+7 (918) 334 45 56");
        directory.add("Павлов", "+7 (913) 778 89 90");

        directory.printAll();

        System.out.println("\n Поиск по фамилии:");

        List<String> phones;

        String searchSurname;

        searchSurname = "Павлов";
        phones = directory.get(searchSurname);
        System.out.println("Телефоны для фамилии " + searchSurname + ":");
        if (phones.isEmpty()) {
            System.out.println("  Не найдено");
        } else {
            for (String phone : phones) {
                System.out.println("  - " + phone);
            }
        }
        searchSurname = "Волков";
        phones = directory.get(searchSurname);
        System.out.println("\nТелефоны для фамилии " + searchSurname + ":");
        if (phones.isEmpty()) {
            System.out.println("  Не найдено");
        } else {
            for (String phone : phones) {
                System.out.println("  - " + phone);
            }
        }
        searchSurname = "Кузнецов";
        phones = directory.get(searchSurname);
        System.out.println("\nТелефоны для фамилии " + searchSurname + ":");
        if (phones.isEmpty()) {
            System.out.println("  Не найдено");
        } else {
            for (String phone : phones) {
                System.out.println("  - " + phone);
            }
        }
    }
}
