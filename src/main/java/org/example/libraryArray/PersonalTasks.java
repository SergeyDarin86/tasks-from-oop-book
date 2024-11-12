package org.example.libraryArray;

import java.util.Arrays;

public class PersonalTasks {

    static final int N = 4;
    static final int MIN = 1;
    static final int MAX = 10;

    static final int Z = 4;

    //задачи из упражнения 1.1.2.1. Часть 1
    public static void main(String[] args) {
        int[] ints = new int[N];
        int[] intsWork = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println(Arrays.toString(intsWork));

        findCountOfMaxValue(intsWork);
        findCountOfValuesMoreThanZ(intsWork);
        countOfNumbersThanLessThanLeftNeighbor(intsWork);
        arrayIsGrowsOrReduces(intsWork);
        findMaxSumBetweenNeighbors(intsWork);
        findBrickWithMaxVolume(ints);
        findRectangleWithMinSquare(ints);
        findAverageOfArrayNumbers(ints);
        findTriangleWithMaxHypotenuse(ints);
        findScalarMultiplicationBetweenTwoVectors();
        findAverageLengthOfRadiusVectors(ints);
    }

    //1
    static void findCountOfMaxValue(int[] ints) {
        int max = Arrays.stream(ints).max().getAsInt();

        int countMax = (int) Arrays.stream(ints).filter(i -> i == max).count();
        System.out.println("max: " + max + ", count: " + countMax);
    }

    //2
    static void findCountOfValuesMoreThanZ(int[] ints) {
        int count = (int) Arrays.stream(ints).filter(i -> i > Z).count();
        System.out.println(count + ": count of numbers more than " + Z);
    }

    //3
    static void findMaxSumBetweenNeighbors(int[] ints) {
        int[] intsMiddle = new int[ints.length - 1];
        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length - 1) {
                intsMiddle[i] = ints[i] + ints[i + 1];
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(intsMiddle));
        System.out.println("max: " + Arrays.stream(intsMiddle).max().getAsInt());
    }

    //4
    static void countOfNumbersThanLessThanLeftNeighbor(int[] ints) {
        int count = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] < ints[i - 1]) {
                count++;
            }
        }
        System.out.println(count + ": less than left neighbor");
    }

    //5
    static void arrayIsGrowsOrReduces(int[] ints) {
        int countMore = 0;
        int countLess = 0;
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] <= ints[i - 1]) {
                countLess++;
            }
            if (ints[i] >= ints[i - 1]) {
                countMore++;
            }
        }

        if (countLess == ints.length - 1) {
            System.out.println("Массив убывающий");
        } else if (countMore == ints.length - 1) {
            System.out.println("Массив возрастающий");
        } else {
            System.out.println("Массив вразнобой");
        }

    }

    //6
    static void findBrickWithMaxVolume(int[] ints) {
        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsB = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsC = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA));
        System.out.println(Arrays.toString(intsB));
        System.out.println(Arrays.toString(intsC));

        int[] bricksVolume = new int[N];

        for (int a = 0; a < intsA.length; a++) {
            for (int b = 0; b < intsB.length; b++) {
                for (int c = 0; c < intsC.length; c++) {
                    if (a == b && a == c)
                        bricksVolume[a] = intsA[a] * intsB[b] * intsC[c];
                }
            }
        }
        System.out.println("---------------------");
        System.out.println(Arrays.toString(bricksVolume));
        System.out.println("----------------------");
        System.out.println(Arrays.stream(bricksVolume).max().getAsInt() + ": Brick with max volume");
    }

    //7
    static void findRectangleWithMinSquare(int[] ints) {
        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsB = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();


        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA));
        System.out.println(Arrays.toString(intsB));


        int[] squareRectangle = new int[N];

        for (int a = 0; a < intsA.length; a++) {
            for (int b = 0; b < intsB.length; b++) {
                if (a == b)
                    squareRectangle[a] = intsA[a] * intsB[b];
            }
        }
        System.out.println("---------------------");
        System.out.println(Arrays.toString(squareRectangle));
        System.out.println("----------------------");
        System.out.println(Arrays.stream(squareRectangle).min().getAsInt() + ": Rectangle with min square");
    }

    //8
    private static int countMoreThanAverage;

    static void findAverageOfArrayNumbers(int[] ints) {
        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA));
        double average = Arrays.stream(intsA).average().getAsDouble();
        countMoreThanAverage = (int) Arrays.stream(intsA).filter(value -> value > average).count();
        System.out.println(average + ": Average");
        System.out.println(getCountMoreThanAverage());

    }

    static int getCountMoreThanAverage() {
        return countMoreThanAverage;
    }

    //9
    static void findTriangleWithMaxHypotenuse(int[] ints) {
        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsB = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA));
        System.out.println(Arrays.toString(intsB));

        double[] hypotenuses = new double[N];

        for (int a = 0; a < intsA.length; a++) {
            for (int b = 0; b < intsB.length; b++) {
                if (a == b)
                    hypotenuses[a] = Math.round(Math.hypot(intsA[a], intsB[b]) * 10 / 10);
            }
        }
        System.out.println(Arrays.toString(hypotenuses));
        System.out.println(Arrays.stream(hypotenuses).max().getAsDouble() + ": Triangle with max hypotenuse");
    }

    //10 Найти скалярное произведение двух векторов a и b

    // https://skillbox.ru/media/code/skalyarnoe-proizvedenie-vektorov-formuly-opredeleniya-svoystva/ - справочная информация о векторах

    public static void findScalarMultiplicationBetweenTwoVectors() {
        int n = 2;
        int[] ints = new int[n];

        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsB = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA) + ": vector A");
        System.out.println(Arrays.toString(intsB) + ": vector B");

        int scalarMultiplication = 0;

        for (int a = 0; a < intsA.length; a++) {
            for (int b = 0; b < intsB.length; b++) {
                if (a == b) {
                    scalarMultiplication += intsA[a] * intsB[b];
                }
            }
        }
        System.out.println(scalarMultiplication + ": Scalar multiplication");
    }

    //11
    static void findAverageLengthOfRadiusVectors(int[] ints) {
        int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();
        int[] intsB = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

        System.out.println("======================================");
        System.out.println(Arrays.toString(intsA));
        System.out.println(Arrays.toString(intsB));

        double[] lengthOfVectors = new double[N];

        for (int a = 0; a < intsA.length; a++) {
            for (int b = 0; b < intsB.length; b++) {
                if (a == b)
                    lengthOfVectors[a] = Math.round(Math.hypot(intsA[a], intsB[b]) * 10 / 10);
            }
        }
        System.out.println(Arrays.toString(lengthOfVectors));
        System.out.println(Arrays.stream(lengthOfVectors).average().getAsDouble() + ": Average length of Vectors");
    }


}
