package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void move() {
        Car car = new Car("tobi");

        int randomNum = car.move();

        assertThat(car.getPosition()).isEqualTo(randomNum >= 4 ? 1 : 0);

    }
}