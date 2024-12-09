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

//        findMaxSumOnSubstrings(array);
//        findMaxSumOfAbsValues(array);
//        findMaxSumOfElementsThatMoreZero(array);
//        findMinSumOfElementsOnSubstrings(array);
//        findMinSumOfAbsValues(array);
//        findMaxGeometricValue(array);
//        findMaxSumOnSubstringsElementsThatMoreZero(array);
        findMaxSumOfElementsOnColumns(array);
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

    //2
    public static void findMaxSumOfAbsValues(int[] array) {

        int[] arrayOfSum = new int[N / 2];

        for (int i = N / 2; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < M / 2; j++) {
                sum += array[j * M + i];
            }
            arrayOfSum[i - N / 2] = sum;
        }
        System.out.println(Arrays.toString(arrayOfSum));
        System.out.println(Arrays.stream(arrayOfSum).map(value -> Math.abs(value)).max().getAsInt() + ": Max sum of abs values");
    }

    //3
    public static void findMaxSumOfElementsThatMoreZero(int[] array) {
        int[] arrayOfSum = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                if (array[j * M + i] < 0) continue;
                sum += array[j * M + i];
            }
            arrayOfSum[i] = sum;
        }

        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": max sum");
    }

    //4
    public static void findMinSumOfElementsOnSubstrings(int[] array) {
        int[] arrayOfSum = new int[N - 1];

        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N - 1; j++) {
                if (j < i)
                    sum += array[i * N + j];
            }
            arrayOfSum[i - 1] = sum;
        }

        System.out.println("------------");
        System.out.println(Arrays.stream(arrayOfSum).min().getAsInt() + ": min sum");
    }

    //5
    public static void findMinSumOfAbsValues(int[] array) {
        int[] arraySumOfAbsValues = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += Math.abs(array[i * M + j]);
            }
            arraySumOfAbsValues[i] = sum;
        }

        System.out.println(Arrays.stream(arraySumOfAbsValues).min().getAsInt() + ": min sum");
    }

    //6
    public static void findMaxGeometricValue(int[] array) {
        double[] arrayOfGeometricValues = new double[N / 2];

        for (int i = N / 2; i < N; i++) {
            int multiplication = 1;
            for (int j = M / 2; j < M; j++) {
                multiplication *= array[i * M + j];
            }
            double geometricValue = Math.pow(multiplication, (float) 1 / (N / 2));
            arrayOfGeometricValues[i - (N / 2)] = geometricValue;
        }

        System.out.println(Arrays.stream(arrayOfGeometricValues).max().getAsDouble() + ": Max geometric value");
    }

    //7
    public static void findMaxSumOnSubstringsElementsThatMoreZero(int[] array) {
        int[] arrayOfSum = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                if (array[i * M + j] < 0) continue;
                sum += array[i * M + j];
            }
            arrayOfSum[i] = sum;
        }

        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": Max sum");
    }

    //8
    public static void findMaxSumOfElementsOnColumns(int[] array) {
        int[] arrayOfSum = new int[N - 1];
        for (int i = 1; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M - 1; j++) {
                if (j < i)
                    sum += array[j * M + i];
            }
            arrayOfSum[i - 1] = sum;
        }

        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": Max sum on columns");
    }

}
