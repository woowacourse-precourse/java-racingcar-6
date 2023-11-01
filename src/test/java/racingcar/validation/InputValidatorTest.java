package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("공백을 포함한 텅 빈 문자열은 오류를 발생시킨다.")
    void carNameWithEmpty() {
        String emptyValue = "  ";
        assertThatThrownBy(() -> validator.carName(emptyValue))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining(INVALID_NAME.toString());

    }

    @Test
    @DisplayName("5자 이상의 문자열은 오류를 발생시킨다.")
    void carNameWithExceedLength() {
        String exceedLength = "thiago";
        assertThatThrownBy(() -> validator.carName(exceedLength))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining(INVALID_NAME_LENGTH.toString());

    }

    @Test
    @DisplayName("중복된 값이 존재하면 예외를 발생시킨다.")
    void carNameWithDuplicate() {
        String duplicateValue = "enzo,enzo";
        assertThatThrownBy(() -> validator.carName(duplicateValue))
                .isInstanceOf(DuplicateNameException.class)
                .hasMessageContaining(DUPLICATE_NAME.toString());
    }

    @Test
    @DisplayName("유효한 값은 예외를 발생시키지 않는다.")
    void carNameWithValidValue() {
        String validValue = "enzo,kai";
        assertThatCode(() -> validator.carName(validValue)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("attemptCount 메서드는 정수 입력에 대해서 오류를 발생시키지 않는다.")
    void attemptCount() {
        String validValue = "5";
        assertThatCode(() -> validator.attemptCount(validValue)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("attemptCount 메서드는 음수는 예외를 발생시킨다.")
    void attemptCountWithNegative() {
        String negative = "-1";
        assertThatThrownBy(() -> validator.attemptCount(negative))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());
    }

    @Test
    @DisplayName("attemptCount 메서드는 숫자가 아닌 값은 예외를 발생시킨다.")
    void attemptCountWithNonNumber() {
        String nonNumber = "text";
        assertThatThrownBy(() -> validator.attemptCount(nonNumber))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());
    }

    @Test
    @DisplayName("attemptCount 메서드는 정수가 아닌 수는 예외를 발생시킨다.")
    void attemptCountWithNonInteger() {
        String nonInteger = "12.3";
        assertThatThrownBy(() -> validator.attemptCount(nonInteger))
                .isInstanceOf(InvalidAttemptCountException.class)
                .hasMessageContaining(INVALID_ATTEMPT_COUNT.toString());
    }
}