package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void 전진_테스트() {
        Car car = new Car("test");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 멈춤_테스트() {
        Car car = new Car("test");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}