package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 3})
    @DisplayName("속력이 4 미만이면 자동차를 전진시킬 수 없다.")
    void isSpeedLessThenFour_Then_CarStop(final int speed) {
        Car car = Car.withName("lsh");
        car.moveForward(speed);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("속력이 4 이상이면 자동차를 전진시킨다.")
    void isSpeedOverFour_Then_CarMove() {
        Car car = Car.withName("lsh");
        car.moveForward(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
