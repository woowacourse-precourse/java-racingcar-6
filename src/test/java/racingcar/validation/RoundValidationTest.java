package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RoundValidationTest {

    @Test
    void validateGap() {
        RoundValidation roundValidation = new RoundValidation();
        String input = " 1";

        assertThatThrownBy(() -> roundValidation.validateGap(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 공백 없이 입력해주세요.");
    }

    @Test
    void validateOnlyInteger() {
        RoundValidation roundValidation = new RoundValidation();
        String input = "3.2";

        assertThatThrownBy(() -> roundValidation.validateOnlyInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 정수만 입력해주세요.");
    }

    @Test
    void validateNumberOfRoundLimit() {
        RoundValidation roundValidation = new RoundValidation();
        String input = "0";

        assertThatThrownBy(() -> roundValidation.validateNumberOfRoundLimit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 1이상으로 입력해주세요.");
    }
}