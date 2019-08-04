package lesson2;

public class ArraySumming {



    public int sum(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;
        if(array.length != 4) {
            throw new MyArraySizeException();
        }

        int val = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for(int j = 0; j < array[i].length; j++) {
                try {
                    val = Integer.parseInt(array[i][j]);
                    sum += val;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }

        return sum;
    }
}
