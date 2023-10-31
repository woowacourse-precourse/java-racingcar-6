package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountValidatorTest {

    private static final String INVALID_INPUT_ERROR_MESSAGE = "숫자를 입력해주세요";
    private static final String MIN_ATTEMPT_COUNT_ERROR_MESSAGE = "1이상을 입력해주세요";

    @Test
    void 시도횟수_정상입력시_숫자변환() {
        String input = "5";
        int attemptCount = AttemptCountValidator.validateAttemptCount(input);
        assertThat(attemptCount).isEqualTo(5);
    }

    @Test
    void 시도횟수_문자입력_예외발생() {
        String input = "abc";
        assertThatThrownBy(() -> AttemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_INPUT_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2"})
    void 시도횟수_1미만입력_예외발생(String input) {
        assertThatThrownBy(() -> AttemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MIN_ATTEMPT_COUNT_ERROR_MESSAGE);
    }
}
