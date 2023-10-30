package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategy.MovingStrategy;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"melon", "apple"})
    void 주어진_이름을_갖는_위치_0인_객체가_생성된다(String name) {
        Car car = Car.from(name);

        assertThat(car.nameValue()).isEqualTo(name);
        assertThat(car.positionValue()).isZero();
    }

    @ParameterizedTest
    @MethodSource("moveArgumentsProvider")
    void 주어진_MovingStrategy에_따라_이동한다(MovingStrategy movingStrategy, int expectedValue) {
        Car car = Car.from("melon");
        car.move(movingStrategy);

        assertThat(car.positionValue()).isEqualTo(expectedValue);
    }

    static Stream<Arguments> moveArgumentsProvider() {
        return Stream.of(
                Arguments.of((MovingStrategy) () -> true, 1),
                Arguments.of((MovingStrategy) () -> false, 0)
        );
    }
}
