package racingcar.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.enums.ErrorMessage;

class TryCountValidatorTest {

    @DisplayName("아무런 값을 입력하지 않았을 경우")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void validateNull(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.NULL_ERROR.getMessage(), exception.getMessage());
    }

    @DisplayName("숫자만 입력할 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ㅁ", "one", "!", "1o1", "-1"})
    void validateInputFormat(String input) {
        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.TRY_COUNT_ONY_NUMBER.getMessage(), exception.getMessage());
    }

    @DisplayName("횟수는 1회 이상만 입력할 수 있다.")
    @Test
    void validateInputRange() {
        // given
        String input = "0";

        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.TRY_COUNT_GT_ZERO.getMessage(), exception.getMessage());
    }

    @DisplayName("횟수는 0으로 시작할 수 없다.")
    @Test
    void validateIsStartZero() {
        // given
        String input = "01";

        // when
        Throwable exception = getException(input);

        // then
        assertEquals(ErrorMessage.TRY_COUNT_NOT_ALLOW_ZERO_IN_FIRST.getMessage(), exception.getMessage());
    }

    private Throwable getException(String input) {
        return assertThrows(IllegalArgumentException.class, () -> {
            TryCountValidator.validate(input);
        });
    }
}