package org.example.libraryArray.chapter2point1;

import java.util.Scanner;

public class Main {

    static final int MIN = 0;
    static final int MAX = 10;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Library obj = new Library();
        int n, m;
        do {
            System.out.println("Введите натуральные числа n и m:");
            n = in.nextInt();
            m = in.nextInt();
        } while (obj.conditionVerify(n, m) == false);

        int[] a = Library.generationArray(MIN, MAX, n, m);
        System.out.println(Library.toString(a, n, m));
        System.out.println("Минимальное значение " + Library.min(a, n, m) +
                "\nМаксимальное значение на четных индексах " + Library.maxEvenIndex(a, n, m));


    }
}
