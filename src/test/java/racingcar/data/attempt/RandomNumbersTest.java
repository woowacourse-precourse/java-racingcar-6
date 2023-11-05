package racingcar.data.attempt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumbersTest {
    @DisplayName("랜덤 정수값 0보다 작은 경우 테스트")
    @Test
    void validateInputNumber_smallerThan0_IAE() {
        // given
        int number = -1;

        // when, then
        assertThatThrownBy(() -> RandomNumbers.validateRandomNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("InputNumber should be between 0 and 9.");
    }

    @DisplayName("랜덤 정수값 9보다 큰 경우 테스트")
    @Test
    void validateInputNumber_biggerThan9_IAE() {
        // given
        int number = 10;

        // when, then
        assertThatThrownBy(() -> RandomNumbers.validateRandomNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("InputNumber should be between 0 and 9.");
    }

    @DisplayName("랜덤 정수값 0에서 9 사이인 경우 테스트")
    @Test
    void validateCarPosition_5_OK() {
        // given
        int number = 5;

        // when, then
        assertThatCode(() -> RandomNumbers.validateRandomNumber(number))
                .doesNotThrowAnyException();
    }
}
