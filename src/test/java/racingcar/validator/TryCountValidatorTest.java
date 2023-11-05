package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ErrorMessage.*;

@DisplayName("TryCountValidatorTest")
class TryCountValidatorTest {

    @Test
    @DisplayName("입력값이 비어있다면 예외를 반환한다.")
    void validateEmpty() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_EMPTY_FOR_INPUT_STRING.getMessage());
    }

    @Test
    @DisplayName("입력값이 정수가 아니라면 예외를 반환한다.")
    void validateDigit() {
        // given
        String input = "a";

        // when, then
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_DIGIT_FOR_INPUT_STRING.getMessage());
    }

    @Test
    @DisplayName("입력값이 양의 정수가 아니라면 예외를 반환한다.")
    void validateSign() {
        // given
        String input = "0";

        // when, then
        assertThatThrownBy(() -> TryCountValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(VALIDATE_SIGN_FOR_INPUT_STRING.getMessage());
    }

}