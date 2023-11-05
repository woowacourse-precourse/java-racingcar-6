package racingcar.data.attempt;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptNumberTest {
    @DisplayName("시도 횟수 0인 경우 테스트")
    @Test
    void validateAttemptNumber_zero_IAE() {
        // given
        int number = 0;

        // when, then
        assertThatThrownBy(() -> AttemptNumber.validateAttemptNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("attemptNumber should be a positive integer.");
    }

    @DisplayName("시도 횟수 음수인 경우 테스트")
    @Test
    void validateAttemptNumber_negative_IAE() {
        // given
        int number = -10;

        // when, then
        assertThatThrownBy(() -> AttemptNumber.validateAttemptNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("attemptNumber should be a positive integer.");
    }

    @DisplayName("시도 횟수 양수인 경우 테스트")
    @Test
    void validateAttemptNumber_positive_OK() {
        // given
        int number = 10;

        // when, then
        assertThatCode(() -> AttemptNumber.validateAttemptNumber(number))
                .doesNotThrowAnyException();
    }
}
