package lesson01;

import org.testng.Assert;
import org.testng.annotations.*;

import com.lesson01.Calculator;


public class CalculatorTest {

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

    @Test(groups ="positive", dataProvider = "additionData", dataProviderClass = TestDataLesson1.class)
    public void testAddition(int a, int b, int expected) {
        // Arrange
        // (calculator already initialized in @BeforeMethod)

        // Act
        int result = calculator.add(a, b);

        // Assert
        Assert.assertEquals(result, expected,
                String.format("Addition failed: %d + %d should equal %d", a, b, expected));
    }


    @Test(groups ="positive", dataProvider = "substractionDate", dataProviderClass = TestDataLesson1.class)
    public void testSubstraction(int a, int b, int expected) {
        // Arrange
        // (calculator already initialized in @BeforeMethod)

        // Act
        int result = calculator.subtract(a, b);

        //Assert
        Assert.assertEquals(result, expected,
                String.format("Substraction failed: %d - %d should equal %d", a, b, expected));
    }

    @Test(groups ="positive", dataProvider = "multiplicationData", dataProviderClass = TestDataLesson1.class)
    public void testMultiplication(int a, int b, int expected) {
        // Arrange
        // (calculator already initialized in @BeforeMethod)

        // Act
        int result = calculator.multiply(a, b);

        //Assert
        Assert.assertEquals(result, expected,
                String.format("Multiplication failed: %d * %d should equal %d", a, b, expected));
    }

    @Test(groups ="positive", dataProvider = "divisionData", dataProviderClass = TestDataLesson1.class)
    public void testDivision(double a, double b, double expected) {
        // Arrange
        // (calculator already initialized in @BeforeMethod)

        // Act
        double result = calculator.divide(a, b);

        //Assert
        Assert.assertEquals(result, expected, 0.01,
                String.format("Division failed: %f / %f should equal %.2f", a, b, expected));
    }

    @Test(groups ="positive", dataProvider = "isEvenData", dataProviderClass = TestDataLesson1.class)
    public void testIsEven(int a, boolean expected) {
        // Arrange
        // (calculator already initialized in @BeforeMethod)

        // Act
        boolean result = calculator.isEven(a);

        //Assert
        Assert.assertEquals(result, expected,
                String.format("IsEven failed for %d. Expected %b but got %b", a, expected, result));
    }


    @Test(groups ="positive")
    public void testDivisionByZeroWithTryCatch() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act & Assert
        try {
            calculator.divide(a, b);
            Assert.fail("Expected ArithmeticException was not thrown");
        } catch (ArithmeticException e) {
            // Test passes
            Assert.assertTrue(e.getMessage().contains("0") || e.getMessage().contains("/ by zero"));
        }
    }

  /*  @Test(expectedExceptions = ArithmeticException.class)
    public void testtestDivisionByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act - should throw exception
        calculator.divide(a, b);

        // No Assert needed - test passes if exception is thrown
    }
  */


}
