package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.COUNT_NOT_INTEGER;
import static racingcar.constant.IllegalArgumentMessage.COUNT_NOT_POSITIVE;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("움직임_횟수")
class CountValidationTest {

    @Test
    @DisplayName("문자_입력_예외")
    void validate_string() {
        String input = "pobi";

        Assertions.assertThatThrownBy(() -> CountValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COUNT_NOT_INTEGER.getMessage());
    }

    @Test
    @DisplayName("음수_입력_예외")
    void validate_negative() {
        String input = "-10";

        Assertions.assertThatThrownBy(() -> CountValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COUNT_NOT_POSITIVE.getMessage());
    }

    @Test
    @DisplayName("소수_입력_예외")
    void validate_decimal() {
        String input = "3.3";

        Assertions.assertThatThrownBy(() -> CountValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(COUNT_NOT_INTEGER.getMessage());
    }
}