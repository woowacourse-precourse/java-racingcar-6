package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
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
        final String expectedName = "jun";
        final Car car = new Car(expectedName);
        assertThat(car.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @MethodSource("provideRandomNumbersForIsGreaterThanFour")
    void isRunnable_메서드_무작위_값이_4이상인_경우에_전진이_가능(final int randomNumber, final boolean expected) {
        final Car car = new Car("jun");

        try (MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(randomNumber);
            assertThat(car.isRunnable()).isEqualTo(expected);
        }
    }

    private static Stream<Arguments> provideRandomNumbersForIsGreaterThanFour() {
        final int START_INCLUSIVE = 1;
        final int END_INCLUSIVE = 9;
        final int CONDITION_FOR_RUNNABLE = 4;
        return IntStream
                .range(START_INCLUSIVE, END_INCLUSIVE)
                .mapToObj(number -> Arguments.of(number, number >= CONDITION_FOR_RUNNABLE));
    }
}
