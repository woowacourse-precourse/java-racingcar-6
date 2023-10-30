package racingcar.race;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberTimeTryExceptionProcessingTest {

    @Test
    public void testCheckNumberWithValidRange() {
        int validNumber = 100; // 유효한 범위 내의 숫자
        int result = NumberTimeTryExceptionProcessing.checkNumber(validNumber);
        assertEquals(validNumber, result);
    }

    @Test
    public void testCheckNumberWithMinValue() {
        int minValue = 1; // 최소 유효 범위 내의 숫자
        int result = NumberTimeTryExceptionProcessing.checkNumber(minValue);
        assertEquals(minValue, result);
    }

    @Test
    public void testCheckNumberWithMaxValue() {
        int maxValue = 2_147_483_646; // 최대 유효 범위 내의 숫자
        int result = NumberTimeTryExceptionProcessing.checkNumber(maxValue);
        assertEquals(maxValue, result);
    }

    @Test
    public void testCheckNumberBelowMinValue() {
        int belowMinValue = 0; // 최소 범위 미만의 숫자
        assertThrows(IllegalArgumentException.class, () -> NumberTimeTryExceptionProcessing.checkNumber(belowMinValue));
    }

    @Test
    public void testCheckNumberAboveMaxValue() {
        int aboveMaxValue = 2_147_483_647; // 최대 범위 초과의 숫자
        assertThrows(IllegalArgumentException.class, () -> NumberTimeTryExceptionProcessing.checkNumber(aboveMaxValue));
    }
}

