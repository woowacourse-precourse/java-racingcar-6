package racingcar.util.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값이 비어있습니다.";
    private static final String CHARACTERS_IN_INPUT_ERROR_MESSAGE = "입력값에 문자가 포함되어 있습니다";

    @DisplayName("자동차 이름에 대한 입력값이 비어있지 않은 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3,car4", "pobi,chobi,cobi,tobi"})
    void validCarNames_test(String carNames) {
        assertDoesNotThrow(() -> {
            InputValidator.validateInputCarNames(carNames);
        });
    }

    @DisplayName("자동차 이름에 대한 입력값이 비어있는 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void invalidCarNames_empty_exception_test(String carNames) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateInputCarNames(carNames));

        assertEquals(EMPTY_INPUT_ERROR_MESSAGE, e.getMessage());
    }

    @DisplayName("시도 횟수에 대한 입력값이 비어있지 않고 숫자인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4"})
    void valid_tryNumber_test(String tryNumber) {
        assertDoesNotThrow(() -> {
            InputValidator.validateInputTryNumber(tryNumber);
        });
    }

    @DisplayName("시도 횟수에 대한 입력값이 비어있는 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = "")
    void invalid_tryNumber_empty_exception_test(String tryNumber) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateInputTryNumber(tryNumber));

        assertEquals(EMPTY_INPUT_ERROR_MESSAGE, e.getMessage());
    }

    @DisplayName("시도 횟수에 대한 입력값이 문자인 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "bc", "d", "-"})
    void invalid_tryNumber_character_exception_test(String tryNumber) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> InputValidator.validateInputTryNumber(tryNumber));

        assertEquals(CHARACTERS_IN_INPUT_ERROR_MESSAGE, e.getMessage());
    }
}
