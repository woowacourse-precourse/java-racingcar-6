package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


import org.junit.jupiter.api.Test;

class CarNameValidatorTest {

    @Test
    void 자동차의_이름들이_5이하일땐_예외_발생하지_않음() {
        String[] validNames = {"pobi", "woni", "jun", "apple", "honi"};
        assertDoesNotThrow(() -> CarNameValidator.validateCarNames(validNames));
    }

    @Test
    void 자동차의_이름이_5초과면_예외_발생() {
        String[] validNames = {"pobi", "woni", "jun", "apple", "honi123"};
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(validNames))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
