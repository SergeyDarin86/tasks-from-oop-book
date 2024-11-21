package org.example.libraryArray.chapter1point2;

import java.util.Arrays;

public class PersonalTasks1_2_2_2 {

    static final int N = 7;
    static final double MIN = -20;
    static final double MAX = 20;

    public static void main(String[] args) {
        double[] doubles = new double[N];
        doubles = Arrays.stream(doubles).map(value -> Math.random() * (MAX - MIN) + MIN).toArray();
        System.out.println(Arrays.toString(doubles));

        findMultiplicationOfFirstTwoPositiveElements(doubles);
    }

    //1
    static void findMultiplicationOfFirstTwoPositiveElements(double[] doubles) {

        int count = 0;
        double multiplication = 1;

        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] > 0) continue;
            count++;
            multiplication *= doubles[i];
            if (count == 2) break;
        }

        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = Math.round(doubles[i]) % 2 != 0 ? multiplication : doubles[i];
        }

        System.out.println(Arrays.toString(doubles));

    }

}
