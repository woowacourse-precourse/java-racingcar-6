package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarPositionTest {
    @Test
    void 초기_값을_갖는_객체를_생성한다() {
        CarPosition carPosition = CarPosition.zero();
        assertThat(carPosition.value()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void 주어진_값을_갖는_객체를_생성한다(int value) {
        CarPosition carPosition = CarPosition.from(value);
        assertThat(carPosition.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void 음수를_갖는_객체를_생성하면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> CarPosition.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
