package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.constant.Constant;

class CarTest {

    @Test
    void moveForward() {
        Car car = new Car();
        car.move(Constant.STEPS_TO_MOVE_FORWARD);
        assertThat(car.getPosition()).isEqualTo(Constant.STEPS_TO_MOVE_FORWARD);
    }
}