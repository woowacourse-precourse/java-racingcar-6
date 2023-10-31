package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomDriveBehaviorTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 무작위_값이_4_이상인_경우_자동차를_전진한다(int randomNumber) {
        // given
        DriveBehavior driveBehavior = new RandomDriveBehavior(() -> randomNumber);
        CarPosition carPosition = CarPosition.createStartPosition();
        int oldPosition = carPosition.getPosition();

        // when
        carPosition.move(driveBehavior.determineDistance());

        // then
        int newPosition = carPosition.getPosition();
        assertThat(newPosition).isEqualTo(oldPosition + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 무작위_값이_4_미만인_경우_자동차를_전진하지_않는다(int randomNumber) {
        // given
        DriveBehavior driveBehavior = new RandomDriveBehavior(() -> randomNumber);
        CarPosition carPosition = CarPosition.createStartPosition();
        int oldPosition = carPosition.getPosition();

        // when
        carPosition.move(driveBehavior.determineDistance());

        // then
        int newPosition = carPosition.getPosition();
        assertThat(newPosition).isEqualTo(oldPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, 10, 11})
    void 무작위_값이_0애서_9_사이의_숫자가_아니라면_예외를_발생시킨다(int randomNumber) {
        // given
        DriveBehavior driveBehavior = new RandomDriveBehavior(() -> randomNumber);
        CarPosition carPosition = CarPosition.createStartPosition();

        // when, then
        assertThatThrownBy(() -> carPosition.move(driveBehavior.determineDistance()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 무작위 값은 0에서 9 사이의 숫자여야 합니다.");
    }
}
