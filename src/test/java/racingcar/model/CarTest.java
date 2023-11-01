package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.exception.ExceptionMessages;
import racingcar.util.generator.RandomNumberGenerator;

public class CarTest {
    private static Stream<Arguments> provideRandomNumbersForIsGreaterThanAndEqualFour() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_MOVING_FORWARD = 4;
        return IntStream
                .range(START_INCLUSIVE, END_INCLUSIVE)
                .mapToObj(number -> Arguments.of(number, number >= CONDITION_MOVING_FORWARD));
    }

    private static Stream<Arguments> provideRandomNumbersForIsLessThanFour() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_MOVING_FORWARD = 4;
        return IntStream
                .range(START_INCLUSIVE, END_INCLUSIVE)
                .mapToObj(number -> Arguments.of(number, number < CONDITION_MOVING_FORWARD));
    }

    @Test
    @DisplayName("자동차는 이름 속성을 가진다.")
    void Car_객체는_이름_속성을_가짐() {
        final String expected = "jun";
        final Car car = new Car(expected);
        final String actual = car.getName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 시 예외를 일으킨다.")
    void name_속성이_5글자를_초과하면_IllegalArgumentException_예외() {
        assertThatThrownBy(() -> new Car("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessages.LIMIT_CAR_NAME_SIZE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbersForIsGreaterThanAndEqualFour")
    void canMoveForward_메서드_무작위_값이_4이상인_경우에_전진이_가능(final int randomNumber, final boolean expected) {
        final Car car = new Car("jun");

        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(randomNumber);
        car.setNumberGenerator(mockGenerator);

        final boolean actual = car.canMoveForward();
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbersForIsLessThanFour")
    @DisplayName("무작위 수가 3 이하이면 멈춘다.")
    void canStop_메서드_무작위_값이_4미만인_경우에_정지(final int randomNumber, final boolean expected) {
        final Car car = new Car("jun");

        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(randomNumber);
        car.setNumberGenerator(mockGenerator);

        final boolean actual = car.canStop();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("무작위 수가 4 이상이면 전진한다.")
    void moveForward_메서드_무작위값이_4이상인_경우애_distance_하나_증가() {
        final Car car = new Car("jun");
        final int CONDITION_MOVING_FORWARD = 4;
        final int expected = 1;

        final RandomNumberGenerator mockGenerator = mock(RandomNumberGenerator.class);
        when(mockGenerator.generate()).thenReturn(CONDITION_MOVING_FORWARD);
        car.setNumberGenerator(mockGenerator);

        car.moveForward();

        final int actual = car.getDistance();
        assertThat(actual).isEqualTo(expected);
    }
}
