package org.example.libraryArray.chapter1point2;

import java.util.Arrays;

public class PersonalTasks1_2_2_1 {
    static final int N = 10;
    static final double MIN = -20;
    static final double MAX = 20;

    public static void main(String[] args) {
        double[] doubles = new double[N];
        double[] doublesWork = Arrays.stream(doubles).map(value -> Math.random() * (MAX - MIN) + MIN).toArray();

        System.out.println(Arrays.toString(doublesWork));
//        divideElementBy2IfItIsEven(doublesWork);
        multiplicateElementBy2(doublesWork);
    }

    //1
    static void divideElementBy2IfItIsEven(double[] doubles) {
        Arrays.stream(doubles).filter(value -> Math.round(value) % 2 == 0).forEach(System.out::println);
    }

    //2
    static void multiplicateElementBy2(double[] doubles) {
        System.out.println("------------------");
        Arrays.stream(doubles).filter(value -> Math.round(value) % 4 == 2).forEach(System.out::println);
        System.out.println("------------------");
        double[] doubles1 = Arrays.stream(doubles).map(value -> Math.round(value) % 4 == 2 ? (value * 2) : value).toArray();
        System.out.println(Arrays.toString(doubles1));
    }
}
