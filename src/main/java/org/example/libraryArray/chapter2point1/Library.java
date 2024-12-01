package org.example.libraryArray.chapter2point1;

public class Library {
    public boolean conditionVerify(int n, int m) {
        String report = "\n n и m должны быть больше 0.\n" +
                "Попробуйте еще раз!\n";
        if (n <= 0 || m <= 0) {
            System.out.println(report);
            return false;
        }
        return true;
    }

    //создание + заполнение одномерного массива, содержащего матрицу
    public static int[] generationArray(final int MIN, final int MAX, int n, int m) {

        int[] array = new int[n * m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                array[i * m + j] = (int) (Math.random() * (MAX - MIN) + MIN);
            }
        }
        return array;
    }

    //экземплярный метод, работающий с одномерным массивом, как с матрицей
    public static int min(int[] array, int n, int m) {
        int min = array[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (min > array[i * m + j])
                    min = array[i * m + j];
            }
        }
        return min;
    }

    //еще один экземплярный метод, работающий с одномерным массивом как с матрицей
    public static int maxEvenIndex(int[] array, int n, int m) {
        int max = array[0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0 && j % 2 == 0 && max < array[i * m + j]) {
                    max = array[i * m + j];
                }
            }
        }

        return max;
    }

    public static String toString(int[] array, int n, int m) {
        String result = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result += array[i * m + j] + " ";
            }
            result = result + "\n";
        }
        return result;
    }
}





















