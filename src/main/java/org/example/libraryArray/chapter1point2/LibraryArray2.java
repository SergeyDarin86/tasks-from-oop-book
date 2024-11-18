package org.example.libraryArray.chapter1point2;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryArray2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library2 obj = new Library2();
        String call = "Введите натуральное число: ";
        int n;

        //ввод и проверка условий
        do {
            System.out.println(call);
            n = in.nextInt();
        }while (obj.conditionVerify(n) == false);
        in.close();

        //создается массив
        double[] a = new double[n];

        //границы генерации
        final double MIN = 0;
        final double MAX = 10;

        //заполнение массива
        obj.generationArray(MIN,MAX,a);
        System.out.println("Исходный массив\n" + Arrays.toString(a));

        obj.arrayDivision(a);
        System.out.println("Результат\n" + Arrays.toString(a));
    }
}

class Library2{

    String report = "Число должно быть " +
            "больше 0.\n" +
            "Попробуйте еще раз!\n";

    //проверка ввода размерности
    boolean conditionVerify(int n) {
        if (n <= 0) {
            System.out.println(report);
            return false;
        }
        return true;
    }

    //только заполнение массива случайными числами типа double
    void generationArray(final double MIN, final double MAX, double[] array) {
        for (int i = 0; i < array.length; i++){
            array[i] = Math.random() * (MAX - MIN) + MIN;
        }
    }

    //вспомогательный экземплярный метод
    double min(double[] array) {
        return Arrays.stream(array).min().getAsDouble();
    }

    //экземплярный метод
    void arrayDivision(double[] array){
        Library2 obj = new Library2();
        double min = obj.min(array);
        //исключение деления на нуль
        min = min !=0 ? min : 1;
        for (int i = 0; i < array.length; i++){
            array[i] = array[i] / min;
        }
    }
}
