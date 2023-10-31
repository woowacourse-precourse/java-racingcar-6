package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void move_메서드_사용시_0_또는_1_반환() {
        Car car = new Car("carName");
        car.move();

        assertThat(car.getDistance()).isBetween(0, 1);
    }
}