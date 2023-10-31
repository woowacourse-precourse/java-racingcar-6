package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class MovingTest {
    private static final int MOVING_FORWARD = 4;

    @DisplayName("움직이지 않으면 위치는 0 이다.")
    @Test
    void moveFailTest() {
        Car car = new Car(new CarName("car"));
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차가 1회 움직이면 위치는 1 이다.")
    @Test
    void moveSuccessTest() {
        assertRandomNumberInRangeTest(
            () -> {
                Car car = new Car(new CarName("car"));
                car.moveRandomly();
                assertThat(car.getPosition()).isEqualTo(1);
            }, MOVING_FORWARD
        );
    }
}
