package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategy.MovingStrategy;

class CarPositionTest {
    @Test
    void 초기_값을_갖는_객체를_생성한다() {
        CarPosition carPosition = CarPosition.zero();
        assertThat(carPosition.value()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10})
    void 주어진_값을_갖는_객체를_생성한다(int value) {
        CarPosition carPosition = CarPosition.from(value);
        assertThat(carPosition.value()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void 음수를_갖는_객체를_생성하면_예외가_발생한다(int value) {
        assertThatThrownBy(() -> CarPosition.from(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("moveArgumentsProvider")
    void 주어진_MovingStrategy에_따라_전진하거나_기존값을_반환한다(MovingStrategy movingStrategy, int expectedValue) {
        CarPosition carPosition = CarPosition.zero();
        CarPosition movedCarPosition = carPosition.move(movingStrategy);

        assertThat(movedCarPosition.value()).isEqualTo(expectedValue);
    }

    static Stream<Arguments> moveArgumentsProvider() {
        return Stream.of(
                Arguments.of((MovingStrategy) () -> true, 1),
                Arguments.of((MovingStrategy) () -> false, 0)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"3:0:true", "2:1:true", "0:0:false", "0:1:false"}, delimiter = ':')
    void 자신의_값이_주어진_값보다_크면_true_아니면_false를_반환한다(int value, int otherValue, boolean expected) {
        CarPosition carPosition = CarPosition.from(value);
        CarPosition otherCarPosition = CarPosition.from(otherValue);

        assertThat(carPosition.biggerThan(otherCarPosition)).isEqualTo(expected);
    }
}
