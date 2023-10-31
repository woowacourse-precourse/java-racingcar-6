package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }
    @Test
    @DisplayName("숫자로 파싱 가능한 입력값은 유효성 검사를 통과한다.")
    public void validateSingleNumberValid() {
        String validNumber = "123";
        inputValidator.validateSingleNumber(validNumber);
    }
    @Test
    @DisplayName("숫자로 파싱 가능한 불가한 소수점 입력값은 유효성 검사를 통과한다.")
    public void validateSingleNumberDoubleValid() {
        String invalidInput = "123.45";
        assertThatThrownBy(() -> inputValidator.validateSingleNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("숫자로 파싱 불가능한 입력값은 예외를 던진다.")
    public void validateSingleNumberInvalid() {
        String invalidInput = "abc";
        assertThatThrownBy(() -> inputValidator.validateSingleNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("delimiter를 제외한 부분에 특수 문자가 없는 경우 유효성 검사를 통과한다.")
    public void validateNamesByDelimiterValid() {
        String input = "John,Smith";
        String delimiter = ",";
        inputValidator.validateNamesByDelimiter(input, delimiter);
    }

    @Test
    @DisplayName("delimiter를 제외한 부분에 특수 문자가 있는 경우 예외를 던진다.")
    public void validateNamesByDelimiterInvalid() {
        String input = "John,D@oe";
        String delimiter = ",";
        assertThatThrownBy(() -> inputValidator.validateNamesByDelimiter(input, delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("delimiter를 제외한 부분에 특수 문자가 포함되어 있습니다.");
    }
}