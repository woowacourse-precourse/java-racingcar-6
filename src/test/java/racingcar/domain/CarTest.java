package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("부여받은 연료가 4 이상이면 자동차는 전진한다")
    void moveForward(final int fuel) {
        // given
        final Car car = new Car("pobi");
        final Position previousPosition = car.getPosition();

        // when
        car.moveForward(fuel);

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(previousPosition.getValue() + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("부여받은 연료가 4 미만이면 자동차는 정지한다")
    void stop(final int fuel) {
        // given
        final Car car = new Car("pobi");
        final Position previousPosition = car.getPosition();

        // when
        car.moveForward(fuel);

        // then
        assertThat(car.getPosition().getValue()).isEqualTo(previousPosition.getValue());
    }
}
