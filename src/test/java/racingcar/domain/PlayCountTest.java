package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayCountTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 시도_횟수가_0이하면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> PlayCount.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
