package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomDriveBehaviorTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 무작위_값이_4_이상인_경우_자동차를_전진한다(int randomNumber) {
        DriveBehavior driveBehavior = new RandomDriveBehavior(() -> randomNumber);
        CarPosition carPosition = new CarPosition();
        int oldPosition = carPosition.getPosition();

        driveBehavior.drive(carPosition);
        int newPosition = carPosition.getPosition();

        assertThat(newPosition).isEqualTo(oldPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 무작위_값이_4_미만인_경우_자동차를_전진하지_않는다(int randomNumber) {
        DriveBehavior driveBehavior = new RandomDriveBehavior(() -> randomNumber);
        CarPosition carPosition = new CarPosition();
        int oldPosition = carPosition.getPosition();

        driveBehavior.drive(carPosition);
        int newPosition = carPosition.getPosition();

        assertThat(newPosition).isEqualTo(oldPosition);
    }
}
