package com.geekseat.app.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FibonacciTest {
    @Autowired
    Fibonacci fibonacci;

    @Test
    public void testFibonacciForZero() {
        BigInteger result = fibonacci.getFibonacci(0);
        assertEquals(BigInteger.ZERO, result);
    }

    @Test
    public void testFibonacciForOne() {
        BigInteger result = fibonacci.getFibonacci(1);
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    public void testFibonacciForSmallNumbers() {
        BigInteger result = fibonacci.getFibonacci(5);
        assertEquals(BigInteger.valueOf(5), result);
    }

    @Test
    public void testFibonacciForLargeNumbers() {
        BigInteger result = fibonacci.getFibonacci(50);
        assertEquals(new BigInteger("12586269025"), result);
    }
}
