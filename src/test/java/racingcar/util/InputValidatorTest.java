package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    @Test
    void 자동차_이름_글자수_검증() {
        assertThatThrownBy(() -> InputValidator.isValidCarNames("pobi,woni,yehyeok"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_중복_검증() {
        assertThatThrownBy(() -> InputValidator.isValidCarNames("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 자동차 이름이 존재합니다.");
    }

    @Test
    void 시도_회수_숫자_검증() {
        assertThatThrownBy(() -> InputValidator.isValidRound("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 회수는 숫자만 가능합니다.");
    }
}