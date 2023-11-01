package racingcar.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class NumberTimeTryExceptionProcessingTest {

    @Test
    public void testCheckNumberWithValidRange() {
        int validNumber = 100; // 유효한 범위 내의 숫자
        int result = NumberTimeTryExceptionProcessing.checkNumber(validNumber);
        assertThat(result).isEqualTo(validNumber);
    }

    @Test
    public void testCheckNumberWithMinValue() {
        int minValue = 1;
        int result = NumberTimeTryExceptionProcessing.checkNumber(minValue);
        assertThat(result).isEqualTo(minValue);
    }

    @Test
    public void testCheckNumberWithMaxValue() {
        int maxValue = 2_147_483_646;
        int result = NumberTimeTryExceptionProcessing.checkNumber(maxValue);
        assertThat(result).isEqualTo(maxValue);
    }

    @Test
    public void testCheckNumberBelowMinValue() {
        int belowMinValue = 0;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NumberTimeTryExceptionProcessing.checkNumber(belowMinValue));
    }

    @Test
    public void testCheckNumberAboveMaxValue() {
        int aboveMaxValue = 2_147_483_647;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> NumberTimeTryExceptionProcessing.checkNumber(aboveMaxValue));
    }
}
