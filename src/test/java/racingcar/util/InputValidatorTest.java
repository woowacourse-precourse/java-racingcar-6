package racingcar.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void 자동차_이름_길이_예외() {
        // given
        List<String> names = Arrays.asList("woni,pobiii".split(","));

        // when, then
        assertThatThrownBy(() -> InputValidator.validateCarNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름 길이는 1이상 5이하입니다.");
    }

    @Test
    void 횟수_숫자가_아닐때_예외() {
        // given
        String input = "a";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateAttemptNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다.");
    }

    @Test
    void 횟수_숫자_범위_예외() {
        // given
        String input = "0";

        // when, then
        assertThatThrownBy(() -> InputValidator.validateAttemptNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1이상입니다.");
    }
}
