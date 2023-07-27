package br.com.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

    @Test
    void testAdd() {
        MathUtils mathUtils = new MathUtils();int expected = 2;
        int actual = mathUtils.add(1, 1);
        Assertions.assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
    void testSubtract() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.subtract(4, 2);
        Assertions.assertEquals(expected, actual, "The subtract method should subtract two numbers");
    }

    @Test
    void testMultiply() {
        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.multiply(2, 1);
        Assertions.assertEquals(expected, actual, "The multiply method should multiply two numbers");
    }

    @Test
    void testDivide() {
        MathUtils mathUtils = new MathUtils();
        Assertions.assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw");
    }

    @Test
    void testComputeCircleArea() {
        MathUtils mathUtils = new MathUtils();
        Assertions.assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return right circle area");
    }
}
