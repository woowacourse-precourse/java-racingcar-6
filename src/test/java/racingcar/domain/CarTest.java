package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 자동차_이름의_길이가_1보다_작으면_예외_발생() {
        // given
        final String carName = "";

        // then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차_이름의_길이가_5보다_크면_예외_발생() {
        // given
        final String carName = "porsche";

        // then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}