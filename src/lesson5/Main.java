package lesson5;

public class Main {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "x"},
        };
        System.out.println();
        try {
            int result = Array.count(arr);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            System.out.println("Обращение к ячейке [4][0]");
            String value = arr[4][0];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e);
        }
    }
}