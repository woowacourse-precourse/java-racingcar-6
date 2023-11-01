package validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static validator.TryCountValidator.validateTryCountMin;
import static validator.TryCountValidator.validateTryCountNumber;

import message.ErrorMessages;
import org.junit.jupiter.api.Test;

class TryCountValidatorTest {

    @Test
    void 시도횟수가_숫자가_아니면_예외발생() {
        String tryCount = "";

        assertThatThrownBy(() -> validateTryCountNumber(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.COUNT_NOT_NUMBER_ERROR);
    }

    @Test
    void 시도횟수가_1회_이상이_아니면_예외발생() {
        String tryCount = "0";

        assertThatThrownBy(() -> validateTryCountMin(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.TRY_COUNT_MIN_ERROR);

    }
}