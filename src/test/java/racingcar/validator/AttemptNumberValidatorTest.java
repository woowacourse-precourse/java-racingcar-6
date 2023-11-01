package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class AttemptNumberValidatorTest {
    @Test
    void validateNumber_should_throw_exception_when_attempts_is_not_a_number() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ATTEMPTS_FORMAT_ERROR);
    }

    @Test
    void validateNumber_should_throw_exception_when_attempts_is_empty() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ATTEMPTS_EMPTY_ERROR);
    }

    @Test
    void validateNumber_should_throw_exception_when_attempts_is_negative() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPTS_ERROR);
    }

    @Test
    void validateNumber_should_throw_exception_when_attempts_is_zero() {
        assertThatThrownBy(() -> AttemptNumberValidator.validateNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_ATTEMPTS_ERROR);
    }
}