package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constant.Constants.MOVING_DISTANCE;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        // given
        Car car = new Car("dsj");
        int result = MOVING_DISTANCE + car.getLocation();

        // when
        car.move();

        //then
        assertThat(result).isEqualTo(car.getLocation());
    }
}