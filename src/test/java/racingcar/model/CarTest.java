package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    Car car = new Car("testCar");

    @Test
    void 자동차위치_초기값0 () {
        assertThat(0).isEqualTo(car.getPosition());
    }
}