package br.com.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


@TestInstance(value = TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @AfterAll
    static void afterAllInit() {
        System.out.println("This needs to run after all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("Add")
    class AddTest {
        @Test
        @DisplayName(value = "Add Two Positive Numbers")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            Assertions.assertEquals(expected, actual, () -> "Should return sum " + expected + " but returned " + actual);
        }

        @Test
        @DisplayName(value = "Add Two Negative Numbers")
        void testAddNegative() {
            int expected = -2;
            int actual = mathUtils.add(-1, -1);
            Assertions.assertEquals(expected, actual, () -> "Should return sum " + expected + " but returned " + actual);
        }

    }

    @Test
    @DisplayName(value = "Subtract")
    void testSubtract() {
        int expected = 2;
        int actual = mathUtils.subtract(4, 2);
        Assertions.assertEquals(expected, actual, "The subtract method should subtract two numbers");
    }

    @Test
    @Tags({@Tag("Math"), @Tag("Multiply")})
    @DisplayName(value = "Multiply")
    void testMultiply() {
        int expected = 2;
        int actual = mathUtils.multiply(2, 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected, actual),
                () -> Assertions.assertEquals(0, mathUtils.multiply(0,10)),
                () -> Assertions.assertEquals(-2, mathUtils.multiply(-2,1))
        );
    }

    @RepeatedTest(3)
    @Tag("repeated")
    @DisplayName(value = "Divide")
    void testDivide() {
        int denominator = 1;
        Assertions.assertEquals(1, mathUtils.divide(1,denominator));
    }

    @RepeatedTest(3)
    @Tag("repeated")
    @DisplayName(value = "Divide by 0 throws")
    void testDivideThrows() {
        int denominator = 0;
        Assumptions.assumingThat(denominator == 0, () -> {
            Assertions.assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, denominator),
                    "Divide by zero should throw");
        } );
    }

    @DisplayName(value = "Circle Area")
    @RepeatedTest(3)
    @Tag("repeated")
    void testComputeCircleArea(RepetitionInfo repetitionInfo) {
            boolean isServerUp = true;
            Assumptions.assumeTrue(isServerUp);
            Assertions.assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
                    "Should return right circle area");
    }

    @Test
    @DisplayName(value = "Disabled method")
    @Disabled
    void testDisabled() {
        Assertions.fail("This test should be disabled");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName(value = "Only on LINUX")
    void testOnlyOnLinux() {
        System.out.println("Should run only on Linux");
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    @DisplayName(value = "Only on WINDOWS")
    void testOnlyOnWindows() {
        System.out.println("Should run only on Windows");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    @DisplayName(value = "Only on Java 11")
    void testOnlyOnJava11() {
        System.out.println("Should run only on Java 11");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    @DisplayName(value = "Only on Java 8")
    void testOnlyOnJava8() {
        System.out.println("Should run only on Java 8");
    }

}
