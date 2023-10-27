package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingRoundResultTest {

    @DisplayName("라운드의 승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideGetWinnerTestArguments")
    void getWinnersTest(List<Car> cars, List<String> expectedWinnerName) {
        RacingRoundResult racingRoundResult = new RacingRoundResult(cars);
        List<String> winner = racingRoundResult.getWinners();
        assertThat(winner).isEqualTo(expectedWinnerName);
    }

    static Stream<Arguments> provideGetWinnerTestArguments() {
        return Stream.of(
                arguments(List.of(
                        setCar("pobi", 3),
                        setCar("woni", 2),
                        setCar("jun", 1)
                ), List.of("pobi")),
                arguments(List.of(
                        setCar("pobi", 3),
                        setCar("woni", 3),
                        setCar("jun", 1)
                ), List.of("pobi", "woni")),
                arguments(List.of(
                        setCar("pobi", 1),
                        setCar("woni", 2),
                        setCar("jun", 2)
                ), List.of("woni", "jun")),
                arguments(List.of(
                        setCar("pobi", 0),
                        setCar("woni", 0),
                        setCar("jun", 0)
                ), List.of("pobi", "woni", "jun"))
        );
    }

    private static Car setCar(String carName, int position) {
        return new Car(carName, new FixedCarEngine(true), new Position(position));
    }
}
