package racingcar;


import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.CarNamesInputValidator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void action_1부터_3사이의_숫자는_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    int positionBefore = car.getPosition();

                    car.action();

                    assertThat(car.getPosition()).isEqualTo(positionBefore);
                },
                STOP
        );
    }

    @Test
    void action_4부터_9사이의_숫자는_이동() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car car = new Car("pobi");
                    int positionBefore = car.getPosition();

                    car.action();

                    assertThat(car.getPosition()).isEqualTo(positionBefore + 1);
                },
                MOVING_FORWARD
        );
    }
}
