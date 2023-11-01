package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.constants.MessageConstants;

public class TryCountValidatorTest {
    @Test
    void 유효한_시도_횟수_검증() {
        String inputTryCount = "5";
        assertThatCode(() -> TryCountValidator.validateTryCount(inputTryCount)).doesNotThrowAnyException();
    }

    @Test
    void 숫자가_아닌_시도_횟수_예외발생() {
        String inputTryCount = "two";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_NUMBER_FORMAT_OR_OUT_OF_INT_RANGE);
    }

    @Test
    void 음수_시도_횟수_예외발생() {
        String inputTryCount = "-3";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_TRY_COUNT);
    }

    @Test
    void 숫자_0_시도_횟수_예외발생() {
        String inputTryCount = "0";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_TRY_COUNT);
    }

    @Test
    void 시도_횟수가_int_범위_초과한_경우_예외발생() {
        String inputTryCount = "2147483648";
        assertThatThrownBy(() -> TryCountValidator.validateTryCount(inputTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MessageConstants.INVALID_NUMBER_FORMAT_OR_OUT_OF_INT_RANGE);
    }
}
