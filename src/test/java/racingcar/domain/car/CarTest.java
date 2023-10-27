package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.carcomponent.CarPositionCompareResult;

public class CarTest {

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 이동한 위치가 같은 차를 비교하면 SAME 을 반환한다")
    void CarMoveAndPositionCompareTest_SAME() {
        Car car_1 = new Car();
        car_1.move(true);
        Car car_2 = new Car();
        car_2.move(true);
        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.SAME);
    }

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 더 많이 이동한 차를 덜 이동한 차와 비교하면 BIG 을 반환한다")
    void CarMoveAndPositionCompareTest_BIG() {
        Car car_1 = new Car();
        car_1.move(true);
        car_1.move(true);
        Car car_2 = new Car();
        car_2.move(true);
        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.BIG);
    }

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 덜 이동한 차를 더 많이 이동한 차와 비교하면 SMALL 을 반환한다")
    void CarMoveAndPositionCompareTest_SMALL() {
        Car car_1 = new Car();
        car_1.move(true);
        Car car_2 = new Car();
        car_2.move(true);
        car_2.move(true);
        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.SMALL);
    }
}
