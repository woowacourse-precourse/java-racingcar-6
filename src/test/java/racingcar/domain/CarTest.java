package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 전진성공횟수_출력() {

        Car car = new Car();
        final int MOVE_FORWARD_COUNT = 7;
        String moveForwardStatus = car.makeMoveForwardStatus(MOVE_FORWARD_COUNT);

        Assertions.assertThat(moveForwardStatus).isEqualTo("-------");
    }
}