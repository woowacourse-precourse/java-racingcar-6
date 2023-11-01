package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

    static Stream<Arguments> testParameters() {
        return Stream.of(
                Arguments.of("car1", 3, "car2", 1, List.of("car1")),
                Arguments.of("car1", 3, "car2", 5, List.of("car2")),
                Arguments.of("car1", 3, "car2", 3, List.of("car1", "car2"))
        );
    }

    @ParameterizedTest(name = "{0}: {1}, {2}: {3} -> 승자 {4}")
    @MethodSource("testParameters")
    void 가장멀리_이동한_차가_승자(String carName1, int location1, String carName2, int location2, List<String> expected) {
        Car mockCar1 = mock(Car.class);
        when(mockCar1.getName()).thenReturn(carName1);
        when(mockCar1.getLocation()).thenReturn(location1);

        Car mockCar2 = mock(Car.class);
        when(mockCar2.getName()).thenReturn(carName2);
        when(mockCar2.getLocation()).thenReturn(location2);

        Game game = new Game(List.of(mockCar1, mockCar2), 5);
        List<String> winners = game.getWinnerNames();
        assertEquals(expected, winners);
    }

    @Test
    void 한_라운드에_모든_차가_이동시도한다() {
        Car mockCar1 = mock(Car.class);
        Car mockCar2 = mock(Car.class);

        Game game = new Game(List.of(mockCar1, mockCar2), 5);

        game.playOneRound();

        verify(mockCar1, times(1)).moveIfPossible();
        verify(mockCar2, times(1)).moveIfPossible();
    }
}
