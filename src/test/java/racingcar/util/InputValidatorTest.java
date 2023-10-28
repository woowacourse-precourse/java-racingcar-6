package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    void 다섯_글자를_넘는_자동차_이름이_있을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,woni,yehyeok"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 중복되는_자동차_이름이_있을_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateCarNames("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 입력받은_round가_숫자가_아닐_때_예외_발생() {
        assertThatThrownBy(() -> InputValidator.validateRound("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 숫자만 가능합니다.");
    }
}