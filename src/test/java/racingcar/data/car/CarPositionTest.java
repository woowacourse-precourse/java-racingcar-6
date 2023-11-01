package racingcar.data.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPositionTest {
    @DisplayName("자동차 위치 0인 경우 테스트")
    @Test
    void validateCarPosition_zero_OK() {
        // given
        int pos = 0;

        // when, then
        assertThatCode(() -> CarPosition.validateCarPosition(pos))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차 위치 음수인 경우 테스트")
    @Test
    void validateCarPosition_negative_IAE() {
        // given
        int pos = -10;

        // when, then
        assertThatThrownBy(() -> CarPosition.validateCarPosition(pos))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("CarPosition cannot be a negative integer.");
    }

    @DisplayName("자동차 위치 양수인 경우 테스트")
    @Test
    void validateCarPosition_positive_OK() {
        // given
        int pos = 10;

        // when, then
        assertThatCode(() -> CarPosition.validateCarPosition(pos))
                .doesNotThrowAnyException();
    }
}
