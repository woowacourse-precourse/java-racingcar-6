package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberValidatorTest {

    public static final Integer MIN_TRY_NUMBER = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MESSAGE = " 이상의 정수값만 입력할 수 있습니다.";

    @DisplayName("입력값이 최소 횟수 이상인 경우 예외가 발생하지 않아야 한다.")
    @Test
    void validTryNumber_test() {
        Integer validCount = MIN_TRY_NUMBER;

        assertDoesNotThrow(() -> {
            TryNumberValidator.validateTryNumber(validCount);
        });
    }

    @DisplayName("입력값이 최소 횟수 미만인 경우 예외가 발생해야 합니다.")
    @Test
    void invalidTryNumber_test() {
        Integer invalidCount = MIN_TRY_NUMBER - 1;

        try {
            TryNumberValidator.validateTryNumber(invalidCount);
        } catch (IllegalArgumentException e) {
            assertEquals(MIN_TRY_NUMBER + SMALLER_THAN_MIN_NUMBER_MESSAGE, e.getMessage());
        }
    }
}