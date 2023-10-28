package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarNamesCheckerTest {
    @Test
    public void testValidCarNames() {
        String validCarNames = "Car1,Car2,Car3";
        assertTrue(Application.checkCarNames(validCarNames));
    }

    @Test
    public void testCarNamesWithSpace() {
        String carNamesWithSpace = "Car1,Car 2,Car3";
        assertFalse(Application.checkCarNames(carNamesWithSpace));
    }

    @Test
    public void testCarNamesWithDuplicate() {
        String carNamesWithDuplicate = "Car1,Car2,Car1";
        assertFalse(Application.checkCarNames(carNamesWithDuplicate));
    }

    @Test
    public void testCarNameTooLong() {
        String carNameTooLong = "Car1,Car2,Car3456789";
        assertFalse(Application.checkCarNames(carNameTooLong));
    }

    @Test
    public void testSingleCarName() {
        String singleCarName = "Car1";
        assertFalse(Application.checkCarNames(singleCarName));
    }

    @Test
    public void testEmptyCarNames() {
        String emptyCarNames = "";
        assertFalse(Application.checkCarNames(emptyCarNames));

//        String str = "car1,,";
//        String[] split = str.split(",");
//        System.out.println(split.length);
//        for(int i=0;i<split.length;i++) System.out.println(split[i]);
    }

    @Test
    public void testCarNamesWithoutComma() {
        String carNamesWithoutComma = "Car1Car2Car3";
        assertFalse(Application.checkCarNames(carNamesWithoutComma));
    }
}
