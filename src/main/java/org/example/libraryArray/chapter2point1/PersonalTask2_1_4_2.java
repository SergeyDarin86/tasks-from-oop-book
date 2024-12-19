package org.example.libraryArray.chapter2point1;

import java.util.Arrays;

public class PersonalTask2_1_4_2 {

    static final int MIN = -10;
    static final int MAX = 10;

    static final int N = 3;
    static final int M = 4;

    public static void main(String[] args) {
        int[] array = generationArray();
        System.out.println(toString(array));
//        findMaxCountZeroElementsOnColumns(array);
//        findCountOfLocalMaxValuesForGeometric(array);
//        findMaxCountNegativeElementsInThirdQuarter(array);
//        findCountOfLocalMinimumOnStrings(array);
//        findMaxSumOfPositiveElementsOnEvenStrings(array);
        findMaxCountOfPositiveElementsOnColumns(array);
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

    //2
    public static void findMaxCountZeroElementsOnColumns(int[] array) {
        int[] arrayOfSum = new int[M];

        for (int i = 0; i < M; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (array[j * M + i] == 0)
                    count++;
            }
            arrayOfSum[i] = count;
        }

        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": Max count of zero elements");
    }

    //3
    public static void findCountOfLocalMaxValuesForGeometric(int[] array) {
        double[] arrayOfGeometricValues = new double[M];

        for (int i = 0; i < M; i++) {
            int multiplication = 1;
            for (int j = 0; j < N; j++) {
                multiplication *= array[j * M + i];
            }
            arrayOfGeometricValues[i] = Math.pow(Math.abs(multiplication), (double) 1 / N);
        }

        System.out.println(Arrays.toString(arrayOfGeometricValues));
        int count = 0;
        for (int i = 1; i < M - 1; i++) {
            if (arrayOfGeometricValues[i - 1] > arrayOfGeometricValues[i] && arrayOfGeometricValues[i + 1] > arrayOfGeometricValues[i])
                count += 2;
        }
        System.out.println(count + ": count of local max values");
    }

    //4
    public static void findMaxCountNegativeElementsInThirdQuarter(int[] array) {
        int[] arrayOfCount = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            int count = 0;
            for (int j = N / 2; j < N; j++) {
                if (array[j * N + i] < 0)
                    count++;
            }
            arrayOfCount[i] = count;
        }

        System.out.println(Arrays.stream(arrayOfCount).max().getAsInt() + ": max count of elements that are less zero");
    }

    //5
    public static void findCountOfLocalMinimumOnStrings(int[] array) {
        int[] arrayOfSum = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += Math.abs(array[i * M + j]);
            }
            arrayOfSum[i] = sum;
        }

        int count = 0;
        for (int i = 1; i < arrayOfSum.length - 1; i++) {
            if (arrayOfSum[i - 1] > arrayOfSum[i] && arrayOfSum[i + 1] > arrayOfSum[i])
                count++;
        }

        System.out.println(count + ": count of local minimum");
    }

    //6
    public static void findMaxSumOfPositiveElementsOnEvenStrings(int[] array) {
        int[] arrayOfSum = new int[N / 2];
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                if (array[i * M + j] < 0 || ((i + 1) % 2 != 0)) continue;
                sum += array[i * M + j];
            }
            if ((i + 1) % 2 == 0)
                arrayOfSum[(i - 1) / 2] = sum;
        }

        System.out.println(Arrays.stream(arrayOfSum).max().getAsInt() + ": max sum of positive elements on even strings");
    }

    //7
    public static void findMaxCountOfPositiveElementsOnColumns(int[] array) {
        int[] arrayOfCount = new int[M];

        for (int i = 0; i < M; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (array[j * M + i] < 0) continue;
                count++;
                arrayOfCount[i] = count;
            }
        }
        System.out.println(Arrays.stream(arrayOfCount).max().getAsInt() + ": max count of positive elements on columns");
    }
}
