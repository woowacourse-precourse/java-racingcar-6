package racingcar;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @DisplayName("자동차 이름 검증_5자 초과_에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"123456", " 12345"})
    void validateName(String name) {

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateName(name));

    }

    @Test
    @DisplayName("횟수 입력 검증_음수_에러 발생")
    void validateNegativeTimes() {

        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTimes(-1));

    }
}