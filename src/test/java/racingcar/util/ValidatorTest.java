package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @DisplayName("빈값 입력 예외 테스트")
    @ValueSource(strings = {"", " ", "  ", "   "})
    void invalidInputsTest1(String input) {
        Assertions.assertThatThrownBy(() -> Validator.isEmpty(input)).
                isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INPUT_VALUE);
    }
}