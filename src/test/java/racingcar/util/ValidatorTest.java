package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}
