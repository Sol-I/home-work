package com.sbrf.reboot.calculator;

public class Calculator {
    public static double getAddition(double i, double i1) {
        return i + i1;
    }

    public static double getSubtraction(double i, double i1) {
        return i - i1;
    }

    public static double getMultiplication(double i, double i1) {
        return i * i1;
    }

    public static double getDivision(double i, double i1) {
        if (i1==0) throw new ArithmeticException();
        else return i / i1;
    }

    public static double getPow(double i, double i1) {
        return Math.pow(i, i1);
    }

    public static int getMax(int i, int i1) {
        return Math.max(i, i1);
    }

    public static boolean isOdd(int i) {
        return i % 2 == 1;
    }

}
