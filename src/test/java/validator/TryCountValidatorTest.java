package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountValidatorTest {

    @DisplayName("시도 횟수는 숫자여야 한다.")
    @Test
    void validateTryCountNumber() {
        String tryCount = "";

        assertThatThrownBy(() -> TryCountValidator.validateTryCountNumber(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.COUNT_NOT_NUMBER_ERROR);
    }

    @DisplayName("시도 횟수는 0보다 커야한다.")
    @Test
    void validateTryCountMin() {
        String tryCount = "0";

        assertThatThrownBy(() -> TryCountValidator.validateTryCountMin(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.TRY_COUNT_MIN_ERROR);

    }
}