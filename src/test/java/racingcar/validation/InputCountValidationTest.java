package racingcar.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputCountValidationTest {

    @Test
    void inputCountValidationTest() {
        Assertions.assertThat(InputCountValidation.inputCountValidation("10")).isEqualTo("10");
    }

    @Test
    void inputCountValidationFailTest() {
        Assertions.assertThatThrownBy(() -> InputCountValidation.inputCountValidation("1a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> InputCountValidation.inputCountValidation("")).isInstanceOf(IllegalArgumentException.class);
    }
}