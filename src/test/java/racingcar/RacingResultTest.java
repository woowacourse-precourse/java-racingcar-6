package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingResultTest {

    @DisplayName("최종 라운드의 승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideGetFinalWinnerTestArguments")
    void getFinalWinnersTest(List<RacingRoundResult> racingRoundResults, List<String> expectedWinners) {
        RacingResult racingResult = new RacingResult();
        for (RacingRoundResult r : racingRoundResults) {
            racingResult.addResult(r);
        }
        List<String> finalWinners = racingResult.getFinalWinners();
        assertThat(finalWinners).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> provideGetFinalWinnerTestArguments() {
        return Stream.of(
                arguments(List.of(
                        new RacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        ))
                ), List.of("pobi", "woni")),
                arguments(List.of(
                        new RacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 3),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        ))
                ), List.of("pobi")),
                arguments(List.of(
                        new RacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 1)
                        )), new RacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 2)
                        ))
                ), List.of("pobi", "woni", "jun"))
        );
    }

    private static Car setCar(String carName, int position) {
        return new Car(carName, new FixedCarEngine(true), new Position(position));
    }
}
