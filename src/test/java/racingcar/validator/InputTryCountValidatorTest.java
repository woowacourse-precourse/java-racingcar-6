package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.utils.ErrorMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputTryCountValidatorTest {

    private final InputTryCountValidator validator = new InputTryCountValidator();

    @DisplayName("TryCount 값이 공백일 경우 IllegalArgumentException 발생")
    @Test
    void validate_WhenInputIsBlank_ThrowsException() {
        String input = "";
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateTryCountIsBlank(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.TRY_COUNT_DOES_NOT_BLANK.getMessage());
    }

    @DisplayName("TryCount 값이 숫자가 아닐 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "cc"})
    void validate_WhenInputIsNotInteger_ThorwsException(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validateIsInteger(input));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.TRY_COUNT_MUST_BE_INTEGER.getMessage());
    }

    @DisplayName("TryCount 값이 양의 정수가 아닐 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 0})
    void validate_WhenTryCountIsNotPositiveInteger_ThrowsException(int tryCount) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> validator.validatePositiveInteger(tryCount));
        assertThat(e.getMessage()).isEqualTo(ErrorMessage.TRY_COUNT_MUST_BE_POSITIVE_INTEGER.getMessage());
    }

    @DisplayName("TryCount 값이 양의 정수인 경우 통과")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10})
    void validate_WhenTryCountIsPositiveInteger_DoesNotThrowException(int tryCount) {
        assertDoesNotThrow(() -> validator.validatePositiveInteger(tryCount));
    }

}