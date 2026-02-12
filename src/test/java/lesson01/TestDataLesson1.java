package lesson01;

import org.testng.annotations.*;


public class TestDataLesson1 {
    @DataProvider(name = "additionData")
    public static Object[][] additionDataProvide() {
        return new Object[][] {
                {5, 3, 8},           // positive + positive
                {-5, 3, -2},         // negative + positive
                {-5, -3, -8},        // negative + negative
                {0, 5, 5},           // zero + positive
                {100, -100, 0}       // result is zero
        };
    }

    @DataProvider(name = "substractionDate")
    public static Object[][] substractionDateProvider() {
        return new Object[][] {
                {5, 3, 2},           // positive - positive
                {3, -5, 8},          // positive - negative
                {-5, -3, -2},        // negative - negative
                {0, 5, -5},           // zero - positive
                {0, -5, 5},           // zero - negative
                {-100, 100, 0}       // result is zero
        };
    }

    @DataProvider(name = "multiplicationData")
    public static Object[][] multiplicationDataProvider() {
        return new Object[][] {
                {5, 3, 15},           // positive * positive
                {3, -5, -15},          // positive * negative
                {-5, -3, 15},        // negative * negative
                {0, 5, 0},           // zero * positive
                {0, -5, 0},           // zero * negative
                {0, 0, 0},            // zero * zero
                //{2147483649, 2, 4294967298},  // integer number to large
                {Integer.MAX_VALUE +1, 2, (Integer.MAX_VALUE +1)*2}       // integer from max integer after + 1 goes to min integer, при умножении идет сдвиг битовый, вот я нолики и получил
        };
    }

    @DataProvider(name = "divisionData")
    public static Object[][] divisionDataProvider() {
        return new Object[][] {
                {6, 3, 2},           // positive / positive
                {6, -3, -2},          // positive / negative
                {-6, -3, 2},        // negative / negative
                {0, 5, 0},           // zero / positive
                {0, -5, 0},           // zero / negative
                {5, 3, 1.66}        // with rounding 1.67?, need to check
                /**
                 *  {5, 0, 0}
                 *  that leads to error ArithmeticException: B cannot be 0!,
                 *  not sure that is a good idea to include that negative case to same data provider
                */
        };
    }

    @DataProvider(name = "isEvenData")
    public static Object[][] isEvenDataProvider() {
        return new Object[][] {
                {6, true},
                {2, true},
                {0, true},
                {-2, true},
                {-1, false},
                {1, false}
        };
    }
}
