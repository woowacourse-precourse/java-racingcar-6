package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void moveForward() {
        Car car = new Car("test", 3);
        assertThat(car.getName()).isEqualTo("test");
        assertThat(car.getForwardCount()).isEqualTo(3);

        car.moveForward();
        assertThat(car.getForwardCount()).isEqualTo(4);
    }
}