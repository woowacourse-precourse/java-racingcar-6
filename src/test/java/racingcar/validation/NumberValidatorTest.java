package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumberValidatorTest {

    @Test
    void 유효성검증_입력값이_1이상의_정수가아닐때_예외발생() {
        assertThatThrownBy(() -> NumberValidator.validateAttemptCount("not a number"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> NumberValidator.validateAttemptCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> NumberValidator.validateAttemptCount("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효성검증_입력값이_1이상의_정수일때_정상() {
        String validInput = "3";
        assertThatCode(() -> NumberValidator.validateAttemptCount(validInput))
                .doesNotThrowAnyException();
    }


}
