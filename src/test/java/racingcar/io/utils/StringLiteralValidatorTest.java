package racingcar.io.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringLiteralValidatorTest {

    @DisplayName("숫자가 아닌 경우 예외를 발생한다.")
    @Test
    void validateIsInteger() {
        // given
        String literal = "asb";

        // when & then
        assertThatThrownBy(() -> StringLiteralValidator.validateIsInteger(literal))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("양의 정수가 아닌 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100", "non-number"})
    void validateIsPositiveInteger(String source) {
        // when & then
        assertThatThrownBy(() -> StringLiteralValidator.validateIsPositiveInteger(source))
                .isInstanceOf(IllegalArgumentException.class);
    }

}