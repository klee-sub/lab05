package com.example.fourbasicopt;

public class Calculator {
    public static double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "−": return a - b;
            case "×": return a * b;
            case "÷":
                if (b == 0) throw new ArithmeticException();
                return a / b;
            default: throw new IllegalArgumentException(operator);
        }
    }
}
