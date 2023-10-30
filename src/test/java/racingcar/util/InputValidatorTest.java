package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    void 자동차_이름을_입력하지_않았을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_CAR_NAMES_EMPTY);
    }

    @Test
    void 다섯_글자를_넘는_자동차_이름이_있을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,woni,yehyeok"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_CAR_NAMES_LENGTH);
    }

    @Test
    void 중복되는_자동차_이름이_있을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_CAR_NAMES_DUPLICATE);
    }

    @Test
    void 구분자가_연속으로_들어갈_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,,woni"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_CAR_NAMES_EMPTY);
    }

    @Test
    void round를_입력하지_않았을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateRound(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_ROUND_EMPTY);
    }

    @Test
    void 입력받은_round가_숫자가_아닐_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateRound("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Constants.INVALID_ROUND_ONE_OR_MORE);
    }
}