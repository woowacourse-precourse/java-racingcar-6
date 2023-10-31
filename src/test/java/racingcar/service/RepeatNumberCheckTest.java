package racingcar.service;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RepeatNumberCheckTest {

    @Test
    void 입력값이_없을_때_예외_발생() {
        String input = "";
        assertThatThrownBy(() -> RepeatNumberCheck.isNothing(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_숫자가_아닐_때_예외_발생() {
        String input = "str";
        assertThatThrownBy(() -> RepeatNumberCheck.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력값이_0일_때_예외_발생() {
        String input = "0";
        assertThatThrownBy(() -> RepeatNumberCheck.isOne(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}