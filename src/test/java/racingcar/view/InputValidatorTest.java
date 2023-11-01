package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @DisplayName("빈값이 입력되면 예외가 발생한다.")
    @Test
    void readEmptyEx() {
        assertThatThrownBy(() -> inputValidator.validateEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
