package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private static final String EMPTY_INPUT_ERROR_MSG = "입력값이 비어있습니다.";
    private static final String CHARACTERS_IN_INPUT_ERROR_MSG = "입력값에 문자가 포함되어 있습니다";

    @DisplayName("자동차 이름 입력값이 비어있는 경우 예외가 발생해야 한다.")
    @Test
    void invalidCarNames_empty_exception_test() {
        String emptyInput = "";

        try {
            InputValidator.validateInputCarNames(emptyInput);
        } catch (IllegalArgumentException e) {
            assertEquals(EMPTY_INPUT_ERROR_MSG, e.getMessage());
        }
    }

    @DisplayName("자동차 이름에 대한 입력값이 비어있지 않은 경우 예외가 발생하지 않는다.")
    @Test
    void validCarNames_test() {
        String nonEmptyInput = "NON_EMPTY";

        assertDoesNotThrow(() -> {
            InputValidator.validateInputCarNames(nonEmptyInput);
        });
    }

    @DisplayName("시도 횟수에 대한 입력값이 비어있지 않고 숫자인 경우 예외가 발생하지 않는다.")
    @Test
    void validTryNumber_test() {
        String tryNumber = "1";

        assertDoesNotThrow(() -> {
            InputValidator.validateInputTryNumber(tryNumber);
        });
    }

    @DisplayName("시도 횟수 입력값이 비어있는 경우 예외가 발생해야 합니다.")
    @Test
    void invalidTryNumber_empty_exception_test() {
        String tryNumber = "";

        try {
            InputValidator.validateInputTryNumber(tryNumber);
        } catch (IllegalArgumentException e) {
            assertEquals(EMPTY_INPUT_ERROR_MSG, e.getMessage());
        }
    }

    @DisplayName("시도 횟수 입력값이 숫자가 아닌 경우 예외가 발생해야 한다.")
    @Test
    void invalidTryNumber_character_exception_test() {
        String tryNumber = "c";

        try {
            InputValidator.validateInputTryNumber(tryNumber);
        } catch (IllegalArgumentException e) {
            assertEquals(CHARACTERS_IN_INPUT_ERROR_MSG, e.getMessage());
        }
    }
}