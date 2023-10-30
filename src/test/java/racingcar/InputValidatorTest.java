package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private static final InputValidator inputValidator = new InputValidator();

    @DisplayName("자동차 이름 검증")
    @ParameterizedTest
    @ValueSource(strings = {"123456", " 12345"})
    void validateName(String name) {

        assertThrows(IllegalArgumentException.class, () -> inputValidator.validateName(name));

    }


    @Test
    void validateTimes() {

    }
}