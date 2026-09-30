package com.example.lab05calculator;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private final Calculator calc = new Calculator();
    private static final double DELTA = 0.000001;
    @Test public void addPositive() { assertEquals(110, calc.add(100, 10), DELTA); }
    @Test public void addNegative() { assertEquals(90, calc.add(100, -10), DELTA); }
    @Test public void subtractPositive() { assertEquals(90, calc.subtract(100, 10), DELTA); }
    @Test public void subtractNegative() { assertEquals(110, calc.subtract(100, -10), DELTA); }
    @Test public void divideNormal() { assertEquals(10, calc.divide(100, 10), DELTA); }
    @Test public void divideZero() { assertEquals(0, calc.divide(100, 0), DELTA); }
    @Test public void divideFraction() { assertEquals(2.5, calc.divide(5, 2), DELTA); }
    @Test public void multiplyNormal() { assertEquals(1000, calc.multiply(100, 10), DELTA); }
    @Test public void multiplyIdentity() { assertEquals(100, calc.multiply(100, 1), DELTA); }
    @Test public void multiplyZero() { assertEquals(0, calc.multiply(100, 0), DELTA); }
}
