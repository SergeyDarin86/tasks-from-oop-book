package org.example.libraryArray.chapter2point1;

import java.util.Arrays;

public class PersonalTask2_1_4_1 {
    static final int MIN = 0;
    static final int MAX = 10;

    static final int N = 4;
    static final int M = 4;

    public static void main(String[] args) {

        int[] array = generationArray();
        System.out.println(toString(array));

        findMaxSumOnSubstrings(array);
    }

    public static int[] generationArray() {
        int[] array = new int[N * M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i * M + j] = (int) (Math.random() * (MAX - MIN) + MIN);
            }
        }
        return array;
    }

    public static String toString(int[] array) {
        String result = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += array[i * M + j] + " ";
            }
            result = result + "\n";
        }
        return result;
    }

    //1
    public static void findMaxSumOnSubstrings(int[] array) {
        int[] arrayOfSum = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < M; j++) {
                sum += array[i * M + j];
            }
            arrayOfSum[i] = sum;
            System.out.println(sum);
        }

        System.out.println("------------");
        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": max sum");
    }

}
