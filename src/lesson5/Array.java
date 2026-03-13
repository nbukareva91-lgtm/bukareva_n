package lesson5;

public class Array {
    public static int count(String[][] array) throws MyException {
        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Ошибка количества строк: " + array.length + " (должно быть 4)"
            );
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException(
                        "Ошибка количества столбцов в строке " + i + ": " +
                                array[i].length + " (должно быть 4)"
                );
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Нечисловое значение в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "'",
                            i, j
                    );
                }
            }
        }
        return sum;
    }
}
