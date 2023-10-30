package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"popobi", "ianbest", "abcdefgh"})
    public void 자동차의_이름은_5글자를_넘을수없다(String carName) {
        // when, then
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 자동차의_초기_위치는_0이다() {
        // given
        Car car = new Car("MyCar");

        // when
        int actual = car.getPosition();

        // then
        Assertions.assertThat(actual).isEqualTo(0);
    }

}