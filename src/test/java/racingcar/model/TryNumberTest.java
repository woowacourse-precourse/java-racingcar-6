package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.exception.TryNumberSizeException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {
    @Test
    void 시도횟수가_0보다_작을_경우_예외() {
        // given
        Integer input = -1;

        // when & then
        assertThatThrownBy(() -> new TryNumber(input))
                .isInstanceOf(TryNumberSizeException.class)
                .hasMessageContaining("시도 횟수는 0 이상이어야 합니다.");
    }
}