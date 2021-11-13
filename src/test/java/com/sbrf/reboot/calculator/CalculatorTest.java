package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
        assertEquals(3.5, Calculator.getDivision(7, 2));
    }

    @Test
    void getDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> Calculator.getDivision(9, 0));
    }

    @Test
    void getPow() {
        assertEquals(8, Calculator.getPow(2, 3));
    }

    @Test
    void getMax() {
        assertEquals(9, Calculator.getMax(9, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void isOdd(int i) {
        final boolean r = Calculator.isOdd(i);
        assertEquals(true, r);
        assertSame(true, r);
        assertTrue(r);
        assertEquals(false, Calculator.isOdd(4));
        assertSame(false, Calculator.isOdd(4));
        assertFalse(Calculator.isOdd(4));
    }

    @Test
    void classHasSevenMethods() {
        assertEquals(7, Calculator.class.getMethods().length - Object.class.getMethods().length);
    }

}