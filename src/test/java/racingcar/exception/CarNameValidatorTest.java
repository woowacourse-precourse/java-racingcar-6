package racingcar.exception;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    private static final Integer CAR_NAME_MAX_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE =
            "자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자 이하만 가능합니다.";

    @DisplayName("자동차 이름이 최대 길이 이하인 경우 예외가 발생하지 않는다.")
    @Test
    void validCarName_test() {
        String validCarName = "C".repeat(CAR_NAME_MAX_LENGTH);

        assertDoesNotThrow(() -> {
            CarNameValidator.validateCarName(validCarName);
        });
    }

    @DisplayName("자동차 이름이 최대 길이보다 긴 경우 예외가 발생해야 한다.")
    @Test
    void testInvalidCarName() {
        String invalidCarName = "C".repeat(CAR_NAME_MAX_LENGTH);

        try {
            CarNameValidator.validateCarName(invalidCarName);
        } catch (IllegalArgumentException e) {
            assertEquals(INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE, e.getMessage());
        }
    }
}