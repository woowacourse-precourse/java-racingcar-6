package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.FixedCarEngine;
import racingcar.domain.Position;
import racingcar.domain.RacingResult;

public class RacingCarServiceTest {

    @DisplayName("RacingCarService 객체를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new RacingCarService())
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱을 시작해 최종 우승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideRaceTestArguments")
    void raceTest(Cars cars, int attemptCounts, List<String> expectedWinners) {
        RacingCarService racingCarService = new RacingCarService();
        RacingResult racingResult = racingCarService.race(cars, attemptCounts);
        List<String> finalWinners = racingCarService.determineWinner(racingResult);
        assertThat(finalWinners).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> provideRaceTestArguments() {
        return Stream.of(
                arguments(new Cars(List.of(
                        setCar("pobi", true, 0),
                        setCar("woni", false, 0),
                        setCar("jun", false, 0)
                )), 3, List.of("pobi")),
                arguments(new Cars(List.of(
                        setCar("pobi", true, 0),
                        setCar("woni", true, 0),
                        setCar("jun", false, 0)
                )), 3, List.of("pobi", "woni")),
                arguments(new Cars(List.of(
                        setCar("pobi", true, 0),
                        setCar("woni", true, 0),
                        setCar("jun", true, 0)
                )), 3, List.of("pobi", "woni", "jun")),
                arguments(new Cars(List.of(
                        setCar("pobi", false, 0),
                        setCar("woni", false, 0),
                        setCar("jun", false, 0)
                )), 10, List.of("pobi", "woni", "jun"))
        );
    }

    private static Car setCar(String carName, boolean engineCanMove, int position) {
        return new Car(carName, new FixedCarEngine(engineCanMove), new Position(position));
    }
}
