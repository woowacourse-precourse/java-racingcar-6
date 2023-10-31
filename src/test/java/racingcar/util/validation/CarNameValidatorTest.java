package racingcar.util.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameValidatorTest {

    private static final Integer CAR_NAME_MAX_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 %s자 이하만 가능합니다.";

    @DisplayName("자동차 이름이 최대 길이 이하인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "abcde", "12345"})
    void validCarName_test(String name) {
        assertDoesNotThrow(() -> {
            CarNameValidator.validateCarName(name);
        });
    }

    @DisplayName("자동차 이름이 최대 길이보다 긴 경우 예외가 발생해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi123", "abcdef", "123456"})
    void invalidCarName_test(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> CarNameValidator.validateCarName(name));

        String errorMessage = String.format(INVALID_CAR_NAME_LENGTH_ERROR_MESSAGE, CAR_NAME_MAX_LENGTH);
        assertEquals(errorMessage, e.getMessage());
    }
}
