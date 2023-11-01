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
import racingcar.domain.car.DriveStrategy;
import racingcar.domain.car.RandomDriveStrategy;

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

    static Stream<Arguments> provideCarsForException() {
        DriveStrategy behavior = new RandomDriveStrategy(RandomDriveStrategy::generateRandomNumber);

        return Stream.of(
                Arguments.of(List.of(Car.createOnStart(behavior, "car1"))),
                Arguments.of(Collections.emptyList())
        );
    }

    static Stream<Arguments> provideCarsForNotException() {
        DriveStrategy behavior = new RandomDriveStrategy(RandomDriveStrategy::generateRandomNumber);

        return Stream.of(
                Arguments.of(
                        List.of(
                                Car.createOnStart(behavior, "car1"),
                                Car.createOnStart(behavior, "car2")
                        )
                ),
                Arguments.of(
                        List.of(
                                Car.createOnStart(behavior, "car1"),
                                Car.createOnStart(behavior, "car2"),
                                Car.createOnStart(behavior,"car3")
                        )
                )
        );
    }
}
