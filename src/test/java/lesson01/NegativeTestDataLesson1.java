package lesson01;

import org.testng.annotations.DataProvider;

public class NegativeTestDataLesson1 {

    @DataProvider(name = "divisionByZeroData")
    public static Object[][] divisionByZeroData() {
        return new Object[][] {
                {10, 0},
                {-5, 0},
                {0, 0}
        };
    }


    @DataProvider(name = "boundaryData")
    public static Object[][] boundaryData() {
        return new Object[][] {
                {Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MIN_VALUE, Integer.MIN_VALUE},
                {Integer.MAX_VALUE, Integer.MIN_VALUE},
                {Integer.MIN_VALUE, Integer.MAX_VALUE},
                {0, Integer.MAX_VALUE},
                {0, Integer.MIN_VALUE}
        };
    }
}