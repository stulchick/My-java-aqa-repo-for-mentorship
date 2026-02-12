package lesson01;

import org.testng.Assert;
import org.testng.annotations.*;
import com.lesson01.Calculator;

public class CalculatorNegativeTest {

    private Calculator calculator;
    private static int testCounter;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("=== Starting Calculator Test Suite ===");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("=== Calculator Test Suite Completed ===");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Setting up Calculator test class");
        testCounter = 0;
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Tests completed. Total tests run: " + testCounter);
    }

    @BeforeMethod
    public void beforeMethod() {
        calculator = new Calculator();
        System.out.println("Preparing for test...");
    }

    @AfterMethod
    public void tearDown() {
        testCounter++;
        System.out.println("Test finished!");
    }

    @Test(groups ="negative", dataProvider = "divisionByZeroData", dataProviderClass = NegativeTestDataLesson1.class)
    public void testDivisionByZeroWithTryCatch(int a, int b) {
        // Arrange

        // Act & Assert
        try {
            calculator.divide(a, b);
            Assert.fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            // Test passes
            Assert.assertTrue(e.getMessage().contains("0") || e.getMessage().contains("/ by zero"));
        }
    }

    @Test(groups ="negative", dataProvider = "boundaryData", dataProviderClass = NegativeTestDataLesson1.class)
    public void testBoundaries(int a, int b) {
        // Arrange

        // Act
        int result = calculator.add(a, b);

        // Test passes
        if (a > 0 && b > 0 && result <= 0) {
            Assert.fail("Found positive overflow: " + a + " + " + b + " = " + result);
        }

        if (a < 0 && b < 0 && result >= 0) {
            Assert.fail("Found negative overflow: " + a + " + " + b + " = " + result);
        }

    }
}