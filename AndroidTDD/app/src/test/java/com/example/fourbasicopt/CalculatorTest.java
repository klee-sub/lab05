package com.example.fourbasicopt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void adds() {
        assertEquals(5, Calculator.calculate(2, 3, "+"), 0);
    }

    @Test
    public void subtracts() {
        assertEquals(-1, Calculator.calculate(2, 3, "−"), 0);
    }

    @Test
    public void multiplies() {
        assertEquals(-7.5, Calculator.calculate(-2.5, 3, "×"), 0);
    }

    @Test
    public void divides() {
        assertEquals(2.5, Calculator.calculate(5, 2, "÷"), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void rejectsDivisionByZero() {
        Calculator.calculate(5, 0, "÷");
    }
}
