package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {

    @Test
    @DisplayName("input_빈_문자열_테스트")
    void isEmptyInput() {
        Assertions.assertThatThrownBy(() -> InputValidation.isEmptyInput(""))
                        .isInstanceOf(IllegalArgumentException.class);
    }
}