package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

public class CarTest {
    private static final int TEST_COUNT = 4;
    private static final String MOVE_FORWARD_RESULT = "-";

    @Test
    void 자동차_전진() {
        Car car = Car.create("pobi");
        String expected = MOVE_FORWARD_RESULT.repeat(TEST_COUNT);

        for (int i = 0; i < TEST_COUNT; i++) {
            car.moveForward();
        }

        assertThat(car.convertPositionToString())
                .isEqualTo(expected);
    }
}
