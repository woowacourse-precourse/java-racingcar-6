package racingcar;

import car.Car;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.RacingCarTestConstants.MOVING_FORWARD;

public class CarTest {

    @Test
    void movingForward_자동차_앞으로_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("test");
                    car.movingForward();
                    assertThat(car.getDistance()).isEqualTo(1);
                },
                MOVING_FORWARD
        );
    }
}
