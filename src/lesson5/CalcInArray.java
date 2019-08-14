package lesson5;

import java.util.concurrent.ThreadLocalRandom;

public class CalcInArray {

    //Одномерный массив
    static final int size = 10000000;
    static final int h = size / 2;
    float[] arr = new float[size];

    //какой цифрой заполняем массив
    static final int num = 1;


    public void simpleMethod() {
        //Заполняют этот массив единицами;
        fillWithNumbers();

        //Засекают время выполнения:
        System.out.println("Обычный метод:");
        long a = System.currentTimeMillis();

        //Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        calcArr(arr, size, 0);

        check();

        //Проверяется время окончания метода
        long b = System.currentTimeMillis();
        System.out.println(b - a+" мс.");

    }

    public void threadMethod() {

        //Заполняют этот массив единицами;
        fillWithNumbers();

        //Засекают время выполнения:
        System.out.println("Метод с потоками:");
        long a = System.currentTimeMillis();

        //Деление одного массива на два:
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(()->{
            calcArr(a1, h, 0);
        });

        Thread t2 = new Thread(()->{
            calcArr(a2, h, h);
        });

        t1.start();
        t2.start();



        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Склейка
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        check();

        //Проверяется время окончания метода
        long b = System.currentTimeMillis();
        System.out.println(b - a+" мс.");

    }

    public void fillWithNumbers() {
        for(int i = 0; i < size; i++) {
            arr[i] = num;
        }
    }

    private void calcArr(float a[], int len, int i2) {
        for(int i = 0; i < len; i++) {
            a[i] = calc(a[i], i2);
            i2++;
        }
    }

    private float calc(float j, int i) {
        return (float) (j * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    private void check() {
        //Проверка на любое число от 0 до size
        int randomNum = ThreadLocalRandom.current().nextInt(0, size);
        System.out.println("Проверяем индекс: "+randomNum);
        boolean ok = arr[randomNum] == calc(num, randomNum);
        System.out.println(ok ? "Алгоритм корректный" : "Что-то пошло не так, значения не верны ");
    }
}
