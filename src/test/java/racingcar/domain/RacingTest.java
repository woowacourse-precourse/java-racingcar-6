package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.MockCar;

class RacingTest {

    @Nested
    @DisplayName("레이싱 조건 확인 테스트")
    class ValidationTest {

        @Test
        @DisplayName("레이싱에 참가하는 차량은 2대 이상 있어야 한다")
        void validationTest_whenSizeIsUnderTwo_throwException() {
            List<String> names = List.of("pobi");
            List<Car> cars = createAlwaysMovingMockCars(names);

            assertThatThrownBy(() -> new Racing(cars))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("레이싱에 참여하는 차는 최소 2대 이상이어야 합니다");
        }

        @Test
        @DisplayName("레이싱에 참가하는 차량들의 이름이 겹치지 않아야 한다")
        void validationTest_whenNameIsOverlapped_throwException() {
            List<String> names = List.of("pobi", "jason", "pobi");
            List<Car> cars = createAlwaysMovingMockCars(names);

            assertThatThrownBy(() -> new Racing(cars))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("레이싱에 참여하는 차 이름이 겹치면 안됩니다");
        }

        List<Car> createAlwaysMovingMockCars(List<String> names) {
            int defaultPosition = 0;
            BooleanSupplier alwaysMovedStrategy = () -> true;

            return names.stream()
                    .map(name -> (Car) new MockCar(name, defaultPosition, alwaysMovedStrategy))
                    .toList();
        }
    }

    @Nested
    @DisplayName("우승자 이름 조회 테스트")
    class WinnerNameTest {

        @Test
        @DisplayName("우승자가 한 명 일 때, 우승자 이름을 찾을 수 있다")
        void findWinnersNameTest_whenWinnerIsOne() {
            Map<String, Integer> nameToPosition = Map.of("pobi", 4, "james", 3, "steve", 3);
            List<Car> cars = createAlwaysMovingMockCars(nameToPosition);
            Racing racing = new Racing(cars);
            List<String> expected = List.of("pobi");

            List<String> actual = racing.findWinnersName();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("우승자가 여러명 일 때, 우승자 이름을 찾을 수 있다")
        void findWinnersNameTest() {
            Map<String, Integer> nameToPosition = Map.of("pobi", 1, "james", 3, "steve", 3);
            List<Car> cars = createAlwaysMovingMockCars(nameToPosition);
            Racing racing = new Racing(cars);

            List<String> actual = racing.findWinnersName();

            assertThat(actual).contains("james", "steve").hasSize(2);
        }

        List<Car> createAlwaysMovingMockCars(Map<String, Integer> nameToPosition) {
            BooleanSupplier alwaysMovedStrategy = () -> true;

            return nameToPosition.keySet().stream()
                    .map(name -> (Car) new MockCar(name, nameToPosition.get(name), alwaysMovedStrategy))
                    .toList();
        }
    }
}