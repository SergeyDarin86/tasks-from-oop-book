package org.example.libraryArray;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;

        do {
            System.out.println("Введите натуральное число");
            n = in.nextInt();
        } while (Library.conditionVerify(n) == false);
        in.close();

        final int MIN = 0;
        final int MAX = 10;

        int[] a = Library.generationArray(MIN, MAX, n);
        System.out.println(Arrays.toString(a));
        Library obj = new Library();
        obj.maxIndex(a);
        System.out.println("Минимальное значение: " + obj.min(a) + "\nИндекс последнего максимального значения: " + obj.getMaxInd());
    }
}

class Library {

    private int indMax = 0;

    static boolean conditionVerify(int n) {
        if (n <= 0) {
            System.out.println("Число должно быть больше 0.\n" +
                    "Попробуйте еще раз!\n");
            return false;
        }
        return true;
    }

    static int[] generationArray(final int MIN, final int MAX, int n) {
        int[] array = new int[n];
        return Arrays.stream(array).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
    }

    int min(int[] array) {
        return Arrays.stream(array).min().getAsInt();
    }

    void maxIndex(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[indMax] <= array[i]) {
                indMax = i;
            }
        }
    }

    int getMaxInd() {
        return indMax;
    }
}
