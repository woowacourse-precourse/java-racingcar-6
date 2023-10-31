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
    void 시도할_횟수는_올바른_범위에_속하면_객체_생성_가능하다(int count) {
        assertDoesNotThrow(() -> TryCount.from(count));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 21})
    void 시도할_횟수는_올바른_범위값을_넘으면_객체_생성할_수_없다(int count) {
        assertThatThrownBy(() -> TryCount.from(count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도할_횟수가_서로_같으면_같은_객체이다() {
        TryCount actualTryCount = TryCount.from(1);
        TryCount expectedTryCount = TryCount.from(1);

        assertThat(actualTryCount).isEqualTo(expectedTryCount);
    }

    @Test
    void 시도할_횟수가_서로_다르면_다른_객체이다() {
        TryCount actualTryCount = TryCount.from(1);
        TryCount expectedTryCount = TryCount.from(2);

        assertThat(actualTryCount).isNotEqualTo(expectedTryCount);
    }

    @Test
    void 시도할_횟수가_서로_같으면_해시코드도_같다() {
        TryCount actualTryCount = TryCount.from(1);
        TryCount expectedTryCount = TryCount.from(1);

        assertThat(actualTryCount.hashCode()).isEqualTo(expectedTryCount.hashCode());
    }
}
