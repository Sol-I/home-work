package com.sbrf.reboot.calculator;

public class Calculator {
    public static int getAddition(int i, int i1) {
        return i + i1;
    }

    public static int getSubtraction(int i, int i1) {
        return i - i1;
    }

    public static int getMultiplication(int i, int i1) {
        return i * i1;
    }

    public static double getDivision(int i, int i1) {
        return (double) i / i1;
    }

    public static double getPow(double i, double i1) {
        return Math.pow(i, i1);
    }

    public static int getMax(int i, int i1) {
        return Math.max(i, i1);
    }

    public static int getMin(int i, int i1) {
        return Math.min(i, i1);
    }
}
