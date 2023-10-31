package racingcar.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputValidatorTest {

    @DisplayName("사용자가 공백으로만 이루어진 문자열을 입력하면 예외 발생")
    @Test
    void inputBlankStringThrowException() {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateUserInput("  "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.BLANK_NOT_ALLOWED);
    }

    @DisplayName("사용자가 빈 문자열을 입력하면 예외 발생")
    @Test
    void inputEmptyStringThrowException() {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateUserInput(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.EMPTY_NOT_ALLOWED);
    }


    @DisplayName("사용자가 입력한 문자열 맨 끝 중 하나라도 쉼표를 입력하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {",pobi,woni", "pobi,woni,", ",pobi,woni,"})
    void inputCommaAtEnds(String input) {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.BOTH_ENDS_COMMA_NOT_ALLOWED);
    }

    @DisplayName("숫자가 아닌 수를 입력하면 예외 발생")
    @Test
    void isNotNumberThrowException() {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("12d3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.ONLY_NUMBER_ALLOWED);
    }

    @DisplayName("0을 입력하면 예외 발생")
    @Test
    void isZeroThrowException() {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.POSITIVE_NUMBER_ALLOWED);
    }

    @DisplayName("음수를 입력하면 예외 발생")
    @Test
    void isNegativeNumberThrowException() {
        //when, then
        assertThatThrownBy(() -> UserInputValidator.validateNumberOfRetriesInput("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UserInputValidator.POSITIVE_NUMBER_ALLOWED);
    }

}