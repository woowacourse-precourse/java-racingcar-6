package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource(value = {"0:1:1", "1:0:1", "0:0:0"}, delimiter = ':')
    void 자신의_CarPosition과_주어진_CarPosition중_더_큰값을_반환한다(int value, int otherValue, int expectedValue) {
        Car car = new Car(CarName.from("apple"), CarPosition.from(value));
        CarPosition carPosition = CarPosition.from(otherValue);

        assertThat(car.biggerPosition(carPosition).value()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:false", "1:0:false", "0:0:true", "1:1:true"}, delimiter = ':')
    void 자신의_CarPosition과_주어진_CarPosition의_값이_같은지_비교한다(int value, int otherValue, boolean expected) {
        Car car = new Car(CarName.from("apple"), CarPosition.from(value));
        CarPosition carPosition = CarPosition.from(otherValue);

        assertThat(car.positionEquals(carPosition)).isEqualTo(expected);
    }
}
