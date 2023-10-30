package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class CarTest {
    @Test
    void 전진() {
        Car car = new Car("car1");
        car.goForward();

        assertThat(car.getLocation()).isEqualTo(1);
    }

}
