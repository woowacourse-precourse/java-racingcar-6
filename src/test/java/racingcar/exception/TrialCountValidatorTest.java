package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TrialCountValidatorTest {

    public static final Integer MIN_TRIAL = 1;
    public static final String SMALLER_THAN_MIN_NUMBER_MSG = MIN_TRIAL + " 이상의 정수값만 입력할 수 있습니다.";

    @DisplayName("입력값이 최소 횟수 이상인 경우 예외가 발생하지 않아야 한다.")
    @Test
    void validTrialCount_test() {
        Integer validCount = MIN_TRIAL;

        assertDoesNotThrow(() -> {
            TrialCountValidator.validateTrialCount(validCount);
        });
    }

    @DisplayName("입력값이 최소 횟수 미만인 경우 예외가 발생해야 합니다.")
    @Test
    void invalidTrialCount_test() {
        Integer invalidCount = MIN_TRIAL - 1;

        try {
            TrialCountValidator.validateTrialCount(invalidCount);
        } catch (IllegalArgumentException e) {
            assertEquals(SMALLER_THAN_MIN_NUMBER_MSG, e.getMessage());
        }
    }
}