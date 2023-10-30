package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingCarsTest {
    @ParameterizedTest
    @MethodSource("provideCarsForException")
    void 자동차의_개수가_2대_이상이_아니라면_예외를_발생시킨다(List<Car> cars) {
        assertThatThrownBy(() -> RacingCars.validateCarCount(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Error: 자동차의 개수는 2대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @MethodSource("provideCarsForNotException")
    void 자동차의_개수는_2대_이상이어야_한다(List<Car> cars) {
        assertThatCode(() -> RacingCars.validateCarCount(cars))
                .doesNotThrowAnyException();
    }

    static Stream<Arguments> provideCarsForException() {
        DriveBehavior behavior = new RandomDriveBehavior(RandomDriveBehavior::generateRandomNumber);

        return Stream.of(
                Arguments.of(List.of(Car.createOnStart(behavior, "car1"))),
                Arguments.of(Collections.emptyList())
        );
    }

    static Stream<Arguments> provideCarsForNotException() {
        DriveBehavior behavior = new RandomDriveBehavior(RandomDriveBehavior::generateRandomNumber);

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
