package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.domain.racing.TryCount;

public class TryCountTest {

    @Test
    public void 시도횟수_정수가아닌_문자일시_예외발생() {
        // given
        String tryCount = "k";

        // when && then
        assertThatThrownBy(() -> TryCount.create(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }

    @Test
    public void 시도횟수_정수범위_벗어난_숫자일시_예외발생() {
        // given
        String tryCount = "2200000000";

        // when && then
        assertThatThrownBy(() -> TryCount.create(tryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 이상 2,147,483,647 이하의 정수 값이 필요합니다.");
    }
}
