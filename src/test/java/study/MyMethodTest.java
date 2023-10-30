package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Application.validateInput;
import static racingcar.Application.validateNumber;

public class MyMethodTest {

    @Test
    void validateInput_입력받은_차들의_자릿수가_5초과면_예외_발생() {
        // input
        String carNamesInput = "jia,  uis, vh1uh3";
        String[] inputs = carNamesInput.split(",");

        assertThatThrownBy(() -> validateInput(inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("CarName can not exceed over 5 character");
    }

    @Test
    void validateNumber_입력받은_횟수가_숫자가_아니면_예외_발생() {
        // input
        String number = "dw";

        assertThatThrownBy(() -> validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("This should be only number");
    }
}
