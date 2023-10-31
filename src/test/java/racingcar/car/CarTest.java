package racingcar.car;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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
        Assertions.assertThat(result).isEqualTo(car.getLocation());
    }
}