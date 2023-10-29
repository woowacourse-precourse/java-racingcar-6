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

}