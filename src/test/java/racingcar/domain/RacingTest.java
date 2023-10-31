package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    }

    List<Car> createAlwaysMovingMockCars(List<String> names) {
        int defaultPosition = 0;
        BooleanSupplier alwaysMovedStrategy = () -> true;

        return names.stream()
                .map(name -> (Car) new MockCar(name, defaultPosition, alwaysMovedStrategy))
                .toList();
    }
}