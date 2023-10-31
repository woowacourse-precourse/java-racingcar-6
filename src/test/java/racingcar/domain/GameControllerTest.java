package racingcar.domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {

    @Test
    void 자동차_전진() {
        final Integer MOVE_FORWARD_NUMBER = 4;
        final Integer STOP_NUMBER = 3;

        GameController controller = new GameController();
        Car car1 = new Car();
        Car car2 = new Car();

        controller.MoveForward(car1, MOVE_FORWARD_NUMBER);
        controller.MoveForward(car2, STOP_NUMBER);

        Integer car1MoveForwardCount = car1.getSuccessMoveForwardCount();
        Integer car2MoveForwardCount = car2.getSuccessMoveForwardCount();

        Assertions.assertThat(car1MoveForwardCount).isEqualTo(1);
        Assertions.assertThat(car2MoveForwardCount).isEqualTo(0);
    }
}