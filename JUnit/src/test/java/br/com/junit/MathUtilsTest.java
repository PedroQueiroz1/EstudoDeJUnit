package br.com.junit;

import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @AfterAll
    static void afterAllInit() {
        System.out.println("This needs to run after all");
    }

    @BeforeEach
    void init() {
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);
        Assertions.assertEquals(expected, actual, "The add method should add two numbers");
    }

    @Test
    void testSubtract() {
        int expected = 2;
        int actual = mathUtils.subtract(4, 2);
        Assertions.assertEquals(expected, actual, "The subtract method should subtract two numbers");
    }

    @Test
    void testMultiply() {
        int expected = 2;
        int actual = mathUtils.multiply(2, 1);
        Assertions.assertEquals(expected, actual, "The multiply method should multiply two numbers");
    }

    @Test
    void testDivide() {
        Assertions.assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
                "Divide by zero should throw");
    }

    @Test
    void testComputeCircleArea() {
        Assertions.assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                "Should return right circle area");
    }
}
