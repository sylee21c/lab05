package com.example.lab05calculator;

/** Pure Java arithmetic engine, independent of the Android UI. */
public class Calculator {
    public double add(double x, double y) { return x + y; }
    public double subtract(double x, double y) { return x - y; }
    // The lecture test expects zero when the divisor is zero.
    public double divide(double x, double y) { return y == 0 ? 0 : x / y; }
    public double multiply(double x, double y) { return x * y; }
}
