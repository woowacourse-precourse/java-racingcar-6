package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 초기_위치_0() {
        // given
        String name = "1234";

        // when
        Car car = Car.from(name);

        // then
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 이름길이_5초과_예외() {

        String name = "123456";

        assertThatThrownBy(() -> Car.from(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}