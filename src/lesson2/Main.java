package lesson2;


public class Main {
    public static void main(String[] args) {
        String[][] arr = {{"1","2","15","28"}, {"6","11","35","0"}, {"17","27","1","12"}, {"18","14","55","SS"}};
        ArraySumming asum =  new ArraySumming();
        try {
            int sum = asum.sum(arr);
            System.out.println("Сумма данных в массиве = "+sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            System.out.println("Некорректный формат ячейки "+e.getCell());
            e.printStackTrace();
        }
    }
}
