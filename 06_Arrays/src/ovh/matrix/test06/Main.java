package ovh.matrix.test06;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);

        System.out.println("La media es " + getAverage(myIntegers));
        System.out.println("La media de la mitad es " + getAverage(myIntegers, myIntegers.length / 2));
    }


    private static double getAverage(int[] myIntegers) {

        return getAverage(myIntegers, myIntegers.length);
    }


    private static double getAverage(int[] myIntegers, int len) {

        if (len <= 0) return 0;

        double result = 0;

        for (int i = 0; i < len; i++) {
            result += myIntegers[i];
        }
        result /= len;

        return result;
    }


    private static int[] getIntegers(int size) {

        int[] result = new int[size];

        System.out.println("Entre " + size + " número enteros:");
        for (int i = 0; i < size; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }
}
