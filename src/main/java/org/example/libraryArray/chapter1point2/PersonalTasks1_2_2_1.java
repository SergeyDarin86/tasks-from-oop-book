package org.example.libraryArray.chapter1point2;

import java.util.Arrays;

public class PersonalTasks1_2_2_1 {
    static final int N = 7;
    static final double MIN = -20;
    static final double MAX = 20;

    public static void main(String[] args) {
        double[] doubles = new double[N];
        double[] doublesWork = Arrays.stream(doubles).map(value -> Math.random() * (MAX - MIN) + MIN).toArray();

        System.out.println(Arrays.toString(doublesWork));
//        divideElementBy2IfItIsEven(doublesWork);
//        multiplicateElementBy2(doublesWork);
//        makeElementEqualsZero(doublesWork);
//        putElementInACube(doublesWork);
//        replaceElementWithIndexThatDividedBy3(doublesWork);
//        replaceElementWithIndexThatDividedBy2(doublesWork);
//        replaceNoEvenElement(doublesWork);
//        replaceElementThatMore5(doublesWork);
//        replaceElementThatOutOfBorders(doublesWork);
//        replaceElementWithIndexDividedBy4(doublesWork);
//        replaceElementThatOutOfBordersNew(doublesWork);
//        replaceElementThatInsideBorders(doublesWork);
//        replaceEverySecondElement(doublesWork);
//        multiplyElementTriple(doublesWork);
//        replaceElementWithSumOfItsIndex(doublesWork);
        replaceElementTwice(doublesWork);
    }

    //1
    static void divideElementBy2IfItIsEven(double[] doubles) {
        Arrays.stream(doubles).filter(value -> Math.round(value) % 2 == 0).forEach(System.out::println);
    }

    //2
    static void multiplyElementBy2(double[] doubles) {
        System.out.println("------------------");
        Arrays.stream(doubles).filter(value -> Math.round(value) % 4 == 2).forEach(System.out::println);
        System.out.println("------------------");
        double[] doubles1 = Arrays.stream(doubles).map(value -> Math.round(value) % 4 == 2 ? (value * 2) : value).toArray();
        System.out.println(Arrays.toString(doubles1));
    }

    //3
    static void makeElementEqualsZero(double[] doubles) {
        Arrays.stream(doubles).map(value -> Math.abs(value) > 7 ? 0 : value).forEach(System.out::println);
    }

    //4
    static void putElementInACube(double[] doubles) {
        Arrays.stream(doubles).map(value -> (Math.round(value) % 2 == 0 && value < 0) ? Math.pow(value, 3) : value).forEach(System.out::println);
    }

    //5
    static void replaceElementWithIndexThatDividedBy3(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (i % 3 != 0) continue;
            doubles[i] = doubles[i] % 5;
        }
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(doubles));
    }

    //6
    static void replaceElementWithIndexThatDividedBy2(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (i % 2 != 0) continue;
            doubles[i] = doubles[i] % 6;
        }
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(doubles));
    }

    //7
    static void replaceNoEvenElement(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> Math.round(value) % 2 != 0 ? (value % 3) : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //8
    static void replaceElementThatMore5(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> value > 5 ? (value * (value / 5)) : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //9
    static void replaceElementThatOutOfBorders(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> (value < -2 || value > 6) ? value + 12 : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //10
    static void replaceElementWithIndexDividedBy4(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (i % 4 != 0) continue;
            doubles[i] = doubles[i] * i;
        }
        System.out.println(Arrays.toString(doubles));
    }

    //11
    static void replaceElementThatOutOfBordersNew(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> (value < -5 || value > 6) ? Math.pow(value, 3) : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //12
    static void replaceElementThatInsideBorders(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> (value > -1 && value < 10) ? value * 3 : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //13
    static void replaceEverySecondElement(double[] doubles) {
        int count = 0;
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] < -3 || doubles[i] > 5) continue;
            count++;
            if (count % 2 != 0) continue;
            doubles[i] = 0;
        }
        System.out.println(Arrays.toString(doubles));
    }

    //14
    static void multiplyElementTriple(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> Math.pow(value, 2) < 16 ? value * 3 : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //15
    static void replaceElementWithSumOfItsIndex(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (Math.round(doubles[i]) % 2 == 0) continue;
            doubles[i] += i;
        }
        System.out.println(Arrays.toString(doubles));
    }

    //16
    static void replaceElementTwice(double[] doubles) {
        for (int i = 0; i < doubles.length; i++) {
            if (Math.round(doubles[i]) / (i + 1) / 2 != 0) {
                doubles[i] += 2;
            }
        }
        System.out.println(Arrays.toString(doubles));
    }
}
