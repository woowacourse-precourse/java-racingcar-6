package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("횟수 입력 유효성 검사")
    void gameCountValidateTest() {

        String input1 = "";
        String input2 = "test";

        Assertions.assertThatThrownBy(() -> InputValidator.gameCountValidate(input1))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.gameCountValidate(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
