package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 자동차의_전진_가능_테스트(int randomNumber) {
        // given
        Car car = new Car("pobi");

        // when
        boolean forward = car.isForward(randomNumber);

        // then
        assertTrue(forward);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 자동차의_전진_불가능_테스트(int randomNumber) {
        // given
        Car car = new Car("pobi");

        // when
        boolean notForward = car.isForward(randomNumber);

        // then
        assertFalse(notForward);
    }
}