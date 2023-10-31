package model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TryCountTest {
    @Test
    public void 이동횟수가_숫자가_아닌_경우_예외_발생() {
        String input = "1.6";
        assertThatThrownBy(() ->new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 0 이상의 정수이어야 합니다.");
    }

    @Test
    public void 이동횟수가_음수인_경우_예외_발생() {
        String input = "-1";
        assertThatThrownBy(() -> new TryCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 음수가 될 수 없습니다.");
    }
}
