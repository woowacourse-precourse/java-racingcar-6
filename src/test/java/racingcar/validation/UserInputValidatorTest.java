package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputValidatorTest {

    @DisplayName("사용자가 공백으로만 이루어진 문자열을 입력하면 예외 발생")
    @Test
    void inputBlankStringThrowException() {
        assertThatThrownBy(() -> UserInputValidator.validateUserInput("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.BLANK_NOT_ALLOWED);
    }

    @DisplayName("사용자가 빈 문자열을 입력하면 예외 발생")
    @Test
    void inputEmptyStringThrowException() {
        assertThatThrownBy(() -> UserInputValidator.validateUserInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.EMPTY_NOT_ALLOWED);
    }

    @DisplayName("숫자가 아닌 수를 입력하면 예외 발생")
    @Test
    void isNotNumberThrowException() {
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("12d3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.ONLY_NUMBER_ALLOWED);
    }

    @DisplayName("0을 입력하면 예외 발생")
    @Test
    void isZeroThrowException() {
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.POSITIVE_NUMBER_ALLOWED);
    }

    @DisplayName("음수를 입력하면 예외 발생")
    @Test
    void isNegativeNumberThrowException() {
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.POSITIVE_NUMBER_ALLOWED);
    }

    @DisplayName("양수를 입력하면 예외가 발생하지 않음")
    @Test
    void isPositiveNumberNotThrowException() {
        UserInputValidator.validateNumberOfRetriesInput("1");
    }

}