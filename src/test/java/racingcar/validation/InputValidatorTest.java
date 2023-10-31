package racingcar.validation;

import org.junit.jupiter.api.Test;
import racingcar.exception.DuplicateNameException;
import racingcar.exception.InvalidAttemptCountException;
import racingcar.exception.InvalidNameException;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.ErrorMessages.*;

class InputValidatorTest {

    private InputValidator validator = new InputValidator();

    @Test
    void carName() {
        String emptyValue = "  ";
        assertThatThrownBy(() -> validator.carName(emptyValue))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining(INVALID_NAME.toString());

        String exceedLength = "thiago";
        assertThatThrownBy(() -> validator.carName(exceedLength))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining(INVALID_NAME_LENGTH.toString());

        String duplicateValue = "enzo,enzo";
        assertThatThrownBy(() -> validator.carName(duplicateValue))
                .isInstanceOf(DuplicateNameException.class)
                .hasMessageContaining(DUPLICATE_NAME.toString());

        String validValue = "enzo,kai";
        assertThatCode(() -> validator.carName(validValue)).doesNotThrowAnyException();
    }

    @Test
    void attemptCount() {
        String negative = "-1";
        assertThatThrownBy(() -> validator.attemptCount(negative))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());

        String invalidValue = "text";
        assertThatThrownBy(() -> validator.attemptCount(invalidValue))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());

        String nonInteger = "12.3";
        assertThatThrownBy(() -> validator.attemptCount(nonInteger))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());

        String validValue = "5";
        assertThatCode(() -> validator.attemptCount(validValue)).doesNotThrowAnyException();
    }
}