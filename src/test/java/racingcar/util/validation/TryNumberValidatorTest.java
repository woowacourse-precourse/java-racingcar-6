package racingcar.util.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryNumberValidatorTest {

    private static final Integer MIN_TRY_NUMBER = 1;
    private static final String SMALLER_THAN_MIN_NUMBER_MESSAGE = " 이상의 정수값만 입력할 수 있습니다.";

    @DisplayName("입력값이 최소 횟수 이상인 경우 예외가 발생하지 않아야 한다.")
    @Test
    void valid_tryNumber_test() {
        Integer validCount = MIN_TRY_NUMBER;

        assertDoesNotThrow(() -> {
            TryNumberValidator.validateTryNumber(validCount);
        });
    }

    @DisplayName("입력값이 최소 횟수 미만인 경우 예외가 발생해야 한다.")
    @Test
    void invalid_tryNumber_test() {
        Integer invalidCount = MIN_TRY_NUMBER - 1;

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> TryNumberValidator.validateTryNumber(invalidCount));
        assertEquals(MIN_TRY_NUMBER + SMALLER_THAN_MIN_NUMBER_MESSAGE, e.getMessage());
    }
}
