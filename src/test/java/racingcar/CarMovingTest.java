package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovingTest {

    @Test
    @DisplayName("자동차는 주어진 이동 전략이 성공하면 따라 움직일 수 있다")
    void car_moving_forward() {
        Car car = new Car("kkk");
        car.move(() -> true);
        assertThat(car.getCurrentStatus().position()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 주어진 이동 전략이 실패하면 따라 움직일 수 없다")
    void car_moving_can_not_move() {
        Car car = new Car("kkk");
        car.move(() -> false);
        assertThat(car.getCurrentStatus().position()).isZero();
    }
}
