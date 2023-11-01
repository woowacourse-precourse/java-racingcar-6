package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.Car;

public class RacingCarsTest {
    @ParameterizedTest
    @MethodSource("provideCarsForException")
    void 자동차의_개수가_2대_이상이_아니라면_예외를_발생시킨다(List<Car> cars) {
        assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 개수는 2대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideCarsForNotException")
    void 자동차의_개수는_2대_이상이어야_한다(List<Car> cars) {
        assertThatCode(() -> new RacingCars(cars))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("provideCarWithDuplicateName")
    void 자동차의_이름이_중복되면_예외를_발생시킨다(List<Car> cars) {
        assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 이름은 중복될 수 없습니다.");
    }

    static Stream<Arguments> provideCarsForException() {
        return Stream.of(
                Arguments.of(createCars(List.of("car1"))),
                Arguments.of(Collections.emptyList())
        );
    }

    static Stream<Arguments> provideCarsForNotException() {
        return Stream.of(
                Arguments.of(createCars(List.of("car1", "car2"))),
                Arguments.of(createCars(List.of("car1", "car2", "car3")))
        );
    }

    static Stream<Arguments> provideCarWithDuplicateName() {
        return Stream.of(
                Arguments.of(createCars(List.of("car1", "car2", "car1"))),
                Arguments.of(createCars(List.of("car1", "car2", "car3", "car3")))
        );
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> Car.createOnStart(() -> 0, carName))
                .toList();
    }
}
