package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;

public class CarTest {
    @Test
    void Car_객체는_이름_속성을_가짐() {
        final String expected = "jun";
        final Car car = new Car(expected);
        final String actual = car.getName();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void name_속성이_5글자를_초과하면_IllegalArgumentException_예외() {
        assertThatThrownBy(() -> new Car("abcdef"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbersForIsGreaterThanAndEqualFour")
    void canMoveForward_메서드_무작위_값이_4이상인_경우에_전진이_가능(final int randomNumber, final boolean expected) {
        final Car car = new Car("jun");

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(randomNumber);
            final boolean actual = car.canMoveForward();
            assertThat(actual).isEqualTo(expected);
        }
    }

    private static Stream<Arguments> provideRandomNumbersForIsGreaterThanAndEqualFour() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_MOVING_FORWARD = 4;
        return IntStream
                .range(START_INCLUSIVE, END_INCLUSIVE)
                .mapToObj(number -> Arguments.of(number, number >= CONDITION_MOVING_FORWARD));
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbersForIsLessThanFour")
    void canStop_메서드_무작위_값이_4미만인_경우에_정지(final int randomNumber, final boolean expected) {
        final Car car = new Car("jun");

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(randomNumber);
            final boolean actual = car.canStop();
            assertThat(actual).isEqualTo(expected);
        }
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
    void moveForward_메서드_무작위값이_4이상인_경우애_distance_하나_증가() {
        final Car car = new Car("jun");
        final int CONDITION_MOVING_FORWARD = 4;
        final String expected = "-";

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt()))
                    .thenReturn(CONDITION_MOVING_FORWARD);

            car.moveForward();

            final String actual = car.getDistanceString();
            assertThat(actual).isEqualTo(expected);
        }
    }
}
