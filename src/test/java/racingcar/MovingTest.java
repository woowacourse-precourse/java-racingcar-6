package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;

public class MovingTest {

    @DisplayName("움직이지 않으면 위치는 0 이다.")
    @Test
    void moveFailTest() {
        Car car = new Car(new CarName("car"));

        assertThat(car.isSamePosition(0)).isTrue();
    }

    @DisplayName("자동차가 1회 움직이면 위치는 1 이다.")
    @Test
    void moveSuccessTest() {
        Car car = new Car(new CarName("car"));

        car.moveForwardIfTrue(true);

        assertThat(car.isSamePosition(1)).isTrue();
    }

    @DisplayName("자동차가 위치와 다른 경우 isSamPosition 은 false 이다.")
    @Test
    void moveSamePositionFailTest() {
        Car car = new Car(new CarName("car"));

        car.moveForwardIfTrue(true);
        car.moveForwardIfTrue(true);

        assertThat(car.isSamePosition(1)).isFalse();
    }
}
