package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    private static final int CAR_DEFAULT_LOCATION = 0;

    @Test
    void 자동차_이름은_5자를_초과할_수_없음() {
        Assertions.assertThatThrownBy(() -> {
            new Car("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다섯자_이하_이름의_자동차는_생성() {
        new Car("abcde");
    }

    @Test
    void 자동차의_시작위치는_0() {
        Car car = new Car("aa");
        assertThat(car.getLocation()).isEqualTo(CAR_DEFAULT_LOCATION);
    }

}