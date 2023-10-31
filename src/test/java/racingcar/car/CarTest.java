package racingcar.car;

import static org.assertj.core.api.Assertions.*;
import static racingcar.constant.Constants.DISTANCE;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void move() {
        // given
        Car car = new Car("dsj");
        int result = DISTANCE + car.getLocation();

        // when
        car.move();

        //then
        assertThat(result).isEqualTo(car.getLocation());
    }
}