package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.common.Size;
import racingcar.entity.Car;

import static org.assertj.core.api.Assertions.assertThat;

class MovingTest {
    MovingStub moving = new MovingStub();

    @Test
    void 전진_실패_경계값_미만() {
        // given
        moving.condition = Size.MOVING_BOUNDARY.getValue() - 1;
        Car car = new Car("test");

        // when
        moving.moveOrStop(car);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진_성공_경계값_이상() {
        // given
        moving.condition = Size.MOVING_BOUNDARY.getValue();
        Car car = new Car("test");

        // when
        moving.moveOrStop(car);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    private static class MovingStub {
        private int condition;

        private void moveOrStop(Car car) {
            if (condition >= Size.MOVING_BOUNDARY.getValue()) {
                car.move();
            }
        }

    }

}