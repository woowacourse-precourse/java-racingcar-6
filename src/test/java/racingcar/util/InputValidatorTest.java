package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @Test
    @DisplayName("입력값이 null이면 예외 발생")
    void givenNull_whenValidate_thenThrowError() {
        assertThatThrownBy(() -> InputValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 값이 null 입니다.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력값 공백 검증 예외 발생")
    void givenBlankInput_whenValidate_thenThrowError(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("값을 입력해 주세요.");
    }

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(strings = {"pobi,woni,jun", "5"})
    @DisplayName("입력값 공백, null 검증 통과")
    void givenInput_whenValidate_thenNoException(String input) {
        assertThatNoException()
                .isThrownBy(() -> InputValidator.validate(input));
    }

}
