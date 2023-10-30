package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("기본_입력")
class InputValidationTest {

    @Test
    @DisplayName("빈_문자열_예외")
    void isEmptyInput() {
        Assertions.assertThatThrownBy(() -> InputValidation.isEmptyInput(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}