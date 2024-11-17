package org.example.libraryArray.chapter1point1;

import java.util.Arrays;

public class PersonalTasksChapter1Part2 {

    static final int N = 5;
    static final int MIN = 1;
    static final int MAX = 10;

    private static final int[] ints = new int[N];
    private static final int[] intsA = Arrays.stream(ints).map(value -> (int) (Math.random() * (MAX - MIN) + MIN)).toArray();

    public static void main(String[] args) {
//        findMultiplicationWithZeroRemains();
//        findSumOfElementsThatMoreThanTheirIndex();
//        findMultiplicationOfOddElements();
//        findElementsMoreThanA();
//        findElementsThatDividedBy2And3WithTheSameRemain();
//        findGeometricMeanValueOfEvenNumbers();
//        findElementsThatDividedBy3WithRemain2();
//        findGeometricMeanValueOfNumbersThatDividedBy4WithRemain3Or1();
//        findElementsThatDividedByItsOwnIndexWithZeroRemain();
//        findCountEvenNumbersThatHaveEvenIndexes();
//        findArithmeticMean();
//        findCountOfElementsThatDividedBy4WithZeroRemain();
//        findMultiplicationOfElementsThatOutOfBorder();
//        findSumOfRemains();
//        findGeometricMeanValueOfElementsWithEvenIndexes();
        findArithmeticMeanOfElementsThatDividedBy3WithZeroRemain();
    }

    public static int[] getArray() {
        return intsA;
    }

    //1
    static void findMultiplicationWithZeroRemains() {
        System.out.println("============================ #1");
        int[] array = getArray();

        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int multiplication = array[i] * array[j];
                if (multiplication % 2 != 0 && multiplication % 3 == 0) {
                    System.out.println(multiplication + " <-- divided with zero by 3 and not 2 | " + array[i] + " x " + array[j]);
                }
            }
        }
    }

    //2
    static void findSumOfElementsThatMoreThanTheirIndex() {
        System.out.println("============================ #2");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > array[i]) {
                System.out.println(i + " <-- index, value: " + array[i]);
                sum += array[i];
            }
        }
        System.out.println(sum + ": sum");
    }

    //3
    static void findMultiplicationOfOddElements() {
        System.out.println("============================ #3");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int multiplication = Arrays.stream(array).filter(value -> value % 2 != 0).reduce((acc, b) -> acc * b).getAsInt();
        System.out.println(multiplication + ": multiplication");
    }

    //4
    static void findElementsMoreThanA() {

        int a = 46;

        System.out.println("============================ #4");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).filter(value -> value * value > a).forEach(System.out::println);

    }

    //5
    static void findElementsThatDividedBy2And3WithTheSameRemain() {
        System.out.println("============================ #5");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).filter(value -> value % 2 == value % 3).forEach(System.out::println);
    }

    //6
    static void findGeometricMeanValueOfEvenNumbers() {
        System.out.println("============================ #6");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));

        int multiplication = 1;
        int count = 0;

        for (int a : array) {
            if (a % 2 != 0) continue;
            count++;
            multiplication *= a;
        }

        double geometricValue = Math.pow(multiplication, (float) 1 / count);
        System.out.println(geometricValue + ": geometricValue");
    }

    //7
    static void findElementsThatDividedBy3WithRemain2() {
        System.out.println("============================ #7");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        Arrays.stream(array).filter(value -> value % 3 == 2).forEach(System.out::println);
    }

    //8
    static void findGeometricMeanValueOfNumbersThatDividedBy4WithRemain3Or1() {
        System.out.println("============================ #8");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));

        int multiplication = 1;
        int count = 0;

        for (int a : array) {
            if (a % 4 == 1 || a % 4 == 3) {
                count++;
                multiplication *= a;
            }
        }

        double geometricValue = Math.pow(multiplication, (float) 1 / count);
        System.out.println(geometricValue + ": geometricValue");
    }

    //9 (index + 1)
    static void findElementsThatDividedByItsOwnIndexWithZeroRemain() {
        System.out.println("============================ #9");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] % (i + 1) == 0) {
                System.out.println(array[i]);
            }
        }
    }

    //10
    static void findCountEvenNumbersThatHaveEvenIndexes() {
        System.out.println("============================ #10");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && i % 2 == 0) {
                System.out.println(array[i]);
            }
        }
    }

    //11
    static void findArithmeticMean() {
        System.out.println("============================ #11");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int count = 0;
        int sumX2 = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 4 == 2) {
                count++;
                sumX2 += array[i] * array[i];
            }
        }

        if (count != 0) {
            System.out.println((sumX2 / count) + ": arithmeticMean");
        }
    }

    //12
    static void findCountOfElementsThatDividedBy4WithZeroRemain() {
        System.out.println("============================ #12");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        long count = Arrays.stream(array).filter(value -> value % 4 == 0).count();
        System.out.println(count + ": Count");
    }

    //13
    static void findMultiplicationOfElementsThatOutOfBorder() {
        int min = 3;
        int max = 7;

        System.out.println("============================ #13");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int multiplication = Arrays.stream(array).filter(value -> (value < min) || (value > max)).reduce((acc, b) -> acc * b).getAsInt();
        System.out.println(multiplication + ": multiplication");
    }

    //14
    static void findSumOfRemains() {
        System.out.println("============================ #14");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int sum = 0;

        for (int a : array) {
            if (a % 3 != 0) {
                sum += a % 4;
            }
        }

        System.out.println(sum + ": sum");
    }

    //15
    static void findGeometricMeanValueOfElementsWithEvenIndexes() {
        System.out.println("============================ #15");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));

        int count = 0;
        int multiplication = 1;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                count++;
                multiplication *= array[i];
            }
        }

        double geometricMeanValue = Math.pow(multiplication, (double) 1 / count);
        System.out.println((Math.round(geometricMeanValue * 100.0) / 100.0) + ": geometricValue");

    }

    //16
    static void findArithmeticMeanOfElementsThatDividedBy3WithZeroRemain() {
        System.out.println("============================ #16");
        int[] array = getArray();
        System.out.println(Arrays.toString(array));
        int count = 0;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 0) {
                count++;
                sum += array[i];
            }
        }

        if (count != 0) {
            double arithmeticMean = (double) sum / count;
            System.out.println(arithmeticMean + ": arithmeticMean");
        }
    }


}
