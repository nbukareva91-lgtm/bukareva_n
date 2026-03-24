package lesson5;

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
class MyArraySizeException extends MyException {
    public MyArraySizeException(String message) {
        super(message);
    }
}
class MyArrayDataException extends MyException {
    private int row;
    private int col;

    public MyArrayDataException(String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;
    }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
