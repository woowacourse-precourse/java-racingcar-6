package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AttemptTest {

    @Test
    void 빈_값_예외_처리() {
        String input = "";

        Assertions.assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸입니다.");
    }

    @Test
    void 숫자가_아닌_값_예외_처리() {
        String input = "abc";

        Assertions.assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수 값이 아닙니다.");
    }

    @Test
    void 숫자_0_보다_작은_값_예외_처리() {
        String input = "0";

        Assertions.assertThatThrownBy(() -> new Attempt(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0보다 큰 수를 입력하세요.");
    }
}
