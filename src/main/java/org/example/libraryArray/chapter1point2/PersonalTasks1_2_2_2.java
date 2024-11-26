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

//        findMultiplicationOfFirstTwoPositiveElements(doubles);
//        findMinElementAtEvenPositions(doubles);
//        findArithmeticMeanOfMinAndMaxValues(doubles);
//        replaceSecondAndLastElements(doubles);
//        findFirstPositiveElement(doubles);
//        findCountOfEvenElements(doubles);
//        replaceSecondOrOtherElement(doubles);
//        defineWhatTheArrayIs(doubles);
//        defineElementsAreOrderedOrNot(doubles);
        findFirstEvenelement(doubles);
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

    //2
    static void findMinElementAtEvenPositions(double[] doubles) {
        double min = doubles[0];
        for (int i = 0; i < doubles.length; i++) {
            if ((i + 1) % 2 != 0) continue;
            if (min < doubles[i]) continue;
            min = doubles[i];
        }

        for (int i = 0; i < doubles.length; i++) {
            if (i % 2 != 0) continue;
            doubles[i] = doubles[i] - min;
        }

        System.out.println(Arrays.toString(doubles));

    }

    //3
    static void findArithmeticMeanOfMinAndMaxValues(double[] doubles) {

        double min = doubles[0];
        double max = doubles[0];

        for (int i = 1; i < doubles.length; i++) {
            if (min > doubles[i]) min = doubles[i];
            if (max < doubles[i]) max = doubles[i];
        }

        final double sr = (max + min) / 2;

        doubles = Arrays.stream(doubles).map(value -> value < sr ? Math.pow(value, 3) : value).toArray();
        System.out.println(Arrays.toString(doubles));
    }

    //4
    static void replaceSecondAndLastElements(double[] doubles) {

        double min = doubles[0];
        double max = doubles[0];

        for (int i = 1; i < doubles.length; i++) {
            if (min > doubles[i]) min = doubles[i];
            if (max < doubles[i]) max = doubles[i];
        }

        double multiplication = 1;

        for (int i = 0; i < doubles.length; i++) {
            if ((doubles[i] < min / 2) || (doubles[i] > max / 2)) continue;
            multiplication *= doubles[i];
        }

        System.out.println(multiplication);

        for (int i = 0; i < doubles.length; i++) {
            if (i == 1 || i == doubles.length - 1) {
                doubles[i] = multiplication;
            }
        }

        System.out.println(Arrays.toString(doubles));

    }

    //5
    static void findFirstPositiveElement(double[] doubles) {

        int index = 0;

        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] > 0) {
                index = i;
                break;
            }
        }

        double sum = Arrays.stream(doubles).filter(value -> value < 0).sum();
        System.out.println(sum);

        for (int i = index; i < doubles.length; i++) {
            if (doubles[i] > 0) continue;
            doubles[i] += Math.abs(sum);
        }

        System.out.println(Arrays.toString(doubles));
    }

    //6
    static void findCountOfEvenElements(double[] doubles) {

        long count = Arrays.stream(doubles).filter(value -> Math.round(value) % 2 != 0).count();
        System.out.println(count + ": count");

        double max = doubles[0];
        int index = 0;
        for (int i = 1; i < doubles.length; i++) {
            if (max > doubles[i]) continue;
            max = doubles[i];
            index = i;
        }

        for (int i = 0; i < doubles.length; i++) {
            if (i != index) continue;
            doubles[i] *= count;
        }

        System.out.println(Arrays.toString(doubles));

    }

    //7
    static void replaceSecondOrOtherElement(double[] doubles) {

        double min = doubles[0];
        double max = doubles[0];

        int indexMin = 0;
        int indexMax = 0;

        for (int i = 1; i < doubles.length; i++) {
            if (min > doubles[i]) {
                min = doubles[i];
                indexMin = i;
            }
            if (max < doubles[i]) {
                max = doubles[i];
                indexMax = i;
            }
        }

        System.out.println(indexMin + " -> minIndex");
        System.out.println(indexMax + " -> maxIndex");

        if (indexMax < indexMin) {
            doubles[1] = min;
        } else {
            doubles[N - 1] = max;
        }

        System.out.println(Arrays.toString(doubles));
    }

    //8
    static void defineWhatTheArrayIs(double[] doubles) {

        int count = 0;
        for (int i = 0; i < doubles.length - 1; i++) {
            if (doubles[i] < doubles[i + 1]) {
                count++;
            }
        }

        if (count == doubles.length - 1) {
            doubles = Arrays.stream(doubles).map(value -> Math.pow(value, 3)).toArray();
        } else {
            double temporary = doubles[1];
            doubles[1] = doubles[doubles.length - 1];
            doubles[doubles.length - 1] = temporary;
        }

        System.out.println(Arrays.toString(doubles));

    }

    //9
    static void defineElementsAreOrderedOrNot(double[] doubles) {

        double min = doubles[0];
        double max = doubles[0];
        int indexMin = 0;
        int indexMax = 0;
        double temporary = 0;

        for (int i = 1; i < doubles.length; i++) {
            if (min > doubles[i]) {
                min = doubles[i];
                indexMin = i;
            }
            if (max < doubles[i]) {
                max = doubles[i];
                indexMax = i;
            }
        }

        int count = 0;
        for (int i = 0; i < doubles.length - 1; i++) {
            if (doubles[i] < doubles[i + 1]) {
                count++;
            } else if (doubles[i] > doubles[i + 1]) {
                System.out.println((i + 1) + ": index with disorder");
                doubles[i + 1] += 2;
                break;
            }
        }

        if (count == doubles.length - 1) {
            temporary = doubles[indexMin];
            doubles[indexMin] = doubles[indexMax];
            doubles[indexMax] = temporary;
        }

        System.out.println(Arrays.toString(doubles));

    }

    //10
    static void findFirstEvenelement(double[] doubles) {
        doubles = Arrays.stream(doubles).map(value -> Math.round(value)).toArray();
        System.out.println(Arrays.toString(doubles));

        int firstEvenIndex = 0;
        for (int i = 0; i < doubles.length; i++) {
            if (Math.round(doubles[i]) % 2 == 0) {
                firstEvenIndex = i;
                break;
            }
        }
        System.out.println(firstEvenIndex);

        double firstNoEvenElement = 1;
        for (int i = 0; i < doubles.length; i++) {
            if (Math.round(doubles[i]) % 2 != 0) {
                firstNoEvenElement = doubles[i];
                break;
            }
        }
        System.out.println(firstNoEvenElement);

        int newStartPosition = firstEvenIndex + 1;

        for (int i = newStartPosition; i < doubles.length; i++) {
            if (Math.round(doubles[i]) % 2 == 0) {
                doubles[i] *= firstNoEvenElement;
            }
        }

        System.out.println(Arrays.toString(doubles));

    }
}
