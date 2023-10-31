package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


import org.junit.jupiter.api.Test;

class CarNamesValidatorTest {

    private static final String CAR_NAME_MINIMUM_ERROR_MESSAGE = "최소 두 대 이상의 자동차 이름을 입력해야 합니다.";
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차의 이름은 5자 이하만 가능합니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "자동차의 이름은 중복될 수 없습니다.";

    @Test
    void 자동차의_갯수가_1대이하_예외_발생() {
        String[] validNames = {"pobi"};
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(validNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_MINIMUM_ERROR_MESSAGE);
    }

    @Test
    void 자동차의_갯수가_2대이상_예외_발생하지않음() {
        String[] validNames = {"pobi", "woni"};
        assertDoesNotThrow(() -> CarNameValidator.validateCarNames(validNames));
    }

    @Test
    void 자동차의_이름이_5이하일땐_예외_발생하지_않음() {
        String[] validNames = {"pobi", "woni", "j", "ap", "ho"};
        assertDoesNotThrow(() -> CarNameValidator.validateCarNames(validNames));
    }

    @Test
    void 자동차의_이름이_5초과면_예외_발생() {
        String[] validNames = {"pobi", "woni", "jun", "apple", "honi123"};
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(validNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_LENGTH_ERROR_MESSAGE);
    }

    @Test
    void 자동차_이름이_중복이면_예외_발생() {
        String[] validNames = {"pobi", "pobi", "jun", "apple", "honi123"};
        assertThatThrownBy(() -> CarNameValidator.validateCarNames(validNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
