package lesson2;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        checkSum(5, 20);
        checkNumber(-10);
        System.out.println(isNegative(8));
        printString("Hello", 3);
        System.out.println(isLeapYear(2020));

        //задание 10
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        //задание 11
        int[] array2 = new int[100];
        System.out.println();
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + " ");
        }
        //задание 12
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println();
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
        //задание 13
        int size = 5;
        int[][] array4 = new int[size][size];
        System.out.println();
        for (int i = 0; i < size; i++) {
            array4[i][i] = 1;
            array4[i][size - 1 - i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array4[i][j] + " ");
            }
            System.out.println();
        }
        //задание 14
        int len = 5 ;
        int initialValue = 7 ;
        int[] result = createArray(len, initialValue);
        for (int i = 0; i < len; i++) {
            System.out.print(result[i] + " ");
        }
    }
    public static int[] createArray(int a, int b) {
        int[] array5 = new int[a];
        for (int i = 0; i < a; i++) {
            array5[i] = b;
        }
        return array5;
    }
    //задание 1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //задание 2
    public static void checkSumSign() {
        int a = 9;
        int b = -8;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
    //задание 3
    public static void printColor() {
        int value = 150;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
    //задание 4
    public static void compareNumbers() {
        int a = 25;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    //задание 5
    public static void checkSum(int a, int b) {
        int sum = a + b;

        if (sum < 10) {
            System.out.println("false");
        } else if (sum > 20) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
    //задание 6
    public static void checkNumber(int a) {
        if (a >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }
    //задание 7
    public static boolean isNegative(int number) {
        if (number < 0) {
            return true;
        } else {
            return false;
        }
    }
    //задание 8
    public static void printString(String text, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(text);
        }
    }
    //задание 9
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }
}