package lesson2;

public class MyArrayDataException extends Exception{

    int i,j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public String getCell() {
        return Integer.toString(i) + ", "+ Integer.toString(j);
    }
}
