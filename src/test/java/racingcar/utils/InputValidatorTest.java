package racingcar.utils;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    @Test
    @DisplayName("자동차 이름 유효성 검사")
    void carNameValidateTest() {

        String input1 = "pobi,woni, ";
        String input2 = ", ";
        String input3 = "";
        String input4 = "pobiiii,woni";

        Assertions.assertThatThrownBy(() -> InputValidator.carNameValidate(input1.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.carNameValidate(input2.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.carNameValidate(input3.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> InputValidator.carNameValidate(input4.split(",")))
                .isInstanceOf(IllegalArgumentException.class);

    }

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
