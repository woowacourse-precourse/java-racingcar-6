package racingcar.model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Nested
   class MoveCarTest {
        // given
        Name testName = new Name("car");
        Distance testDistance = new Distance();
        Car testCar = new Car(testName, testDistance);

        @Test
        void 숫자가_4_이상일_경우_전진한다() {
            // given
            Integer input = 4;
            Integer carPosition = testCar.carDistance.getDistance();

            // when
            testCar.move(input);

            // then
            assertThat(testCar.carDistance.getDistance()).isEqualTo(carPosition + 1);
        }

        @Test
        void 숫자가_4_미만이면_전진하지_않는다() {
            // given
            Integer input = 0;
            Integer carPosition = testCar.carDistance.getDistance();

            // when
            testCar.move(input);

            // then
            assertThat(testCar.carDistance.getDistance()).isEqualTo(carPosition);
        }
    }
}