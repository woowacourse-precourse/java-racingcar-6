package racingcar.checker;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import racingcar.domain.Checker;

public class CheckerTest {

    @Test
    void 값이_4_이상일_때_확인() {
        int num = 4;

        assertThat(Checker.checkAtLest4(num)).isEqualTo(true);
    }

    @Test
    void 값이_4_이하일_때_확인() {
        int num = 0;

        assertThat(Checker.checkAtLest4(num)).isEqualTo(false);
    }

    @Test
    void 값이_음수일_때_확인() {
        int num = -1;

        assertThatThrownBy(() -> Checker.checkAtLest4(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("불가능한 값이 들어왔습니다.");
    }

    @Test
    void 값이_10_이상일_때_확인() {
        int num = 10;

        assertThatThrownBy(() -> Checker.checkAtLest4(num))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("불가능한 값이 들어왔습니다.");
    }
}
