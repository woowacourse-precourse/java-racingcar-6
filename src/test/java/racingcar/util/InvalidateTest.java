package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InvalidateTest {
    @Test
    void 숫자_예외처리() {
        String number = "12~4%g";

        assertThatThrownBy(() -> Invalidate.checkNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }
}