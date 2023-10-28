package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 20})
    void 시도할_횟수는_최소값보단_같거나_크고_최대값보단_같거나_작아야한다(int count) {
        assertDoesNotThrow(() -> TryCount.from(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 21})
    void 시도할_횟수는_가능한_범위값을_넘으면_안된다(int count) {
        assertThatThrownBy(() -> TryCount.from(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수끼리_서로_값이_같으면_같은_객체이다() {
        TryCount actualTryCount = TryCount.from(1);
        TryCount expectedTryCount = TryCount.from(1);

        assertThat(actualTryCount).isEqualTo(expectedTryCount);
    }
}
