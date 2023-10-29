package racingcar.io.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}