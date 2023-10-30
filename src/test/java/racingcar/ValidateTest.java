package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static validate.InputValidation.validateNumericInput;

public class ValidateTest {

    @Test
    public void validateNumericInput_입력된_값에_숫자가_아닌_문자가_포함되어있으면_예외_발생() {
        String input = "1a";

        assertThatThrownBy(() -> validateNumericInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 값에 숫자가 아닌 값이 포함되어있습니다.");
     }
}
