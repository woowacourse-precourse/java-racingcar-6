package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarPositionTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void 자동차의_위치를_움직인다(int distance) {
        // given
        CarPosition carPosition = CarPosition.createStartPosition();
        int oldPosition = carPosition.getPosition();

        // when
        carPosition.move(distance);

        // then
        int newPosition = carPosition.getPosition();
        assertThat(newPosition).isEqualTo(oldPosition + distance);
    }
}
