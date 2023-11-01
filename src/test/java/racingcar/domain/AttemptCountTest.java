package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AttemptCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void 시도할_횟수가_0번_이하인_경우_예외를_발생시킨다(int attemptCount) {
        assertThatThrownBy(() -> new AttemptCount(attemptCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }
}
