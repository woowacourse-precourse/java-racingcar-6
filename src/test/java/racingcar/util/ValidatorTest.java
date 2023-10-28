package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest(name = "입력값이 공백이면 예외 발생")
    @ValueSource(strings = {"", "  "})
    void givenBlankInput_whenIsBlankInput_thenThrowError(String input) {
        assertThatThrownBy(() -> Validator.isBlankInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력해 주세요.");
    }

    @Test
    @DisplayName("입력값이 null이면 예외 발생")
    void givenNull_whenIsNullInput_thenThrowError() {
        assertThatThrownBy(() -> Validator.isNullInput(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 입니다.");
    }

    @ParameterizedTest(name = "입력값이 정상적으로 주어지면 예외가 발생하지 않음 : {0}")
    @ValueSource(strings = {"pobi,woni,jun", "5"})
    void givenInput_whenIsNullInput_thenNoException(String input) {
        assertThatNoException().isThrownBy(() -> Validator.isNullInput(input));
    }

}
