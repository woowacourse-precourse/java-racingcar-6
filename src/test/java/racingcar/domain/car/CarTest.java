package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarName;
import racingcar.domain.car.CarPosition;

class CarTest {

    @Nested
    @DisplayName("차동차 움직임 테스트")
    class MovingTest {

        @Test
        @DisplayName("차가 앞으로 갈 때, 앞으로 한 칸 움직인다")
        void moveTest_whenCarMoved() {
            BooleanSupplier alwaysGoStrategy = () -> true;
            Car car = new Car(CarName.from("pobi"), CarPosition.create(), alwaysGoStrategy);
            int expectedPosition = 1;

            car.move();

            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }

        @Test
        @DisplayName("차가 정지할 때, 제자리에 있는다")
        void moveTest_whenCarStopped() {
            BooleanSupplier alwaysStopStrategy = () -> false;
            Car car = new Car(CarName.from("pobi"), CarPosition.create(), alwaysStopStrategy);
            int expectedPosition = 0;

            car.move();

            assertThat(car.getPosition()).isEqualTo(expectedPosition);
        }
    }
}
