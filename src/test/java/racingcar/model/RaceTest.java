package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Nested
    @DisplayName("moveForward 함수에서 ")
    class MoveForwardTest {
        @DisplayName("4이상의 숫자는 앞으로 전진할 수 있다고 판별한다.")
        @ValueSource(ints = {4, 5, 6, 7, 8, 9})
        @ParameterizedTest
        void canMoveForwardTest(int number) {
            Car car1 = new Car("a");
            Car car2 = new Car("b");
            Car car3 = new Car("c");

            List<Car> cars = List.of(car1, car2, car3);

            int roundCount = 5;

            Race race = new Race(cars, roundCount);

            assertThat(race.canMoveForward(number)).isTrue();
        }

        @DisplayName("3미만의 숫자는 앞으로 전진할 수 없다고 판별한다.")
        @ValueSource(ints = {1, 2, 3})
        @ParameterizedTest
        void cannotMoveForwardTest(int number) {
            Car car1 = new Car("a");
            Car car2 = new Car("b");
            Car car3 = new Car("c");

            List<Car> cars = List.of(car1, car2, car3);

            int roundCount = 5;

            Race race = new Race(cars, roundCount);

            assertThat(race.canMoveForward(number)).isFalse();
        }
    }
}