package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();

        // when
        car1.move();

        // then
        assertThat(car1.getDistance()).as("moved car").isEqualTo(1);
        assertThat(car2.getDistance()).as("stopped car").isEqualTo(0);
    }
}