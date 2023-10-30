package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void moveForward() {
        Car car = new Car();
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }
}