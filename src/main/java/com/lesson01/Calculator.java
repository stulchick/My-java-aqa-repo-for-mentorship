package com.lesson01;

public class Calculator {

    /**
     * Adds two numbers
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a+b;
    }

    /**
     * Subtracts b from a
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a-b;
    }

    /**
     * Multiplies two numbers
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a*b;
    }

    /**
     * Divides a by b
     * @return quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public double divide(double a, double b) {
        if (b == 0){
            throw new ArithmeticException("B cannot be 0!");
        }
        return a / b;
    }

    /**
     * Checks if number is even
     * @return true if number is even, false otherwise
     */
    public boolean isEven(int number) {

        return number % 2 == 0;
    }
}
