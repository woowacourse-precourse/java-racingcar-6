package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.carcomponent.CarPositionCompareResult;

public class CarTest {
    private final String CAR1_NAME = "car1";
    private final String CAR2_NAME = "car2";
    private Car car_1;
    private Car car_2;

    @BeforeEach
    void init() {
        car_1 = new Car(CAR1_NAME);
        car_2 = new Car(CAR2_NAME);
    }

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 이동한 위치가 같은 차를 비교하면 SAME 을 반환한다")
    void CarMoveAndPositionCompareTest_SAME() {
        car_1.move(true);

        car_2.move(true);

        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.SAME);
    }

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 더 많이 이동한 차를 덜 이동한 차와 비교하면 BIG 을 반환한다")
    void CarMoveAndPositionCompareTest_BIG() {
        car_1.move(true);
        car_1.move(true);

        car_2.move(true);

        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.BIG);
    }

    @Test
    @DisplayName("자동차에서 move 함수를 통해 위치를 동할 수 있다. 덜 이동한 차를 더 많이 이동한 차와 비교하면 SMALL 을 반환한다")
    void CarMoveAndPositionCompareTest_SMALL() {
        car_1.move(true);

        car_2.move(true);
        car_2.move(true);

        CarPositionCompareResult result = car_1.comparePosition(car_2);
        Assertions.assertThat(result).isEqualTo(CarPositionCompareResult.SMALL);
    }

    @Test
    @DisplayName("getName 메서드로 이름을 반환받는다.")
    void carNameTest() {
        Assertions.assertThat(car_1.getCarName()).isEqualTo(CAR1_NAME);
    }

    @Test
    @DisplayName("전진에 대한 결과 메세지를 toString 메서드로 반환한다")
    void carMoveResultMessageTest() {
        car_2.move(true);
        car_2.move(true);
        Assertions.assertThat(car_2.toString()).isEqualTo(CAR2_NAME + " : --");
    }
}
