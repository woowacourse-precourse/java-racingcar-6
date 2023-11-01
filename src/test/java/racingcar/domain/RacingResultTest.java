package racingcar.domain;

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

public class RacingResultTest {

    @DisplayName("getRacingRoundResult()를 통해 얻어낸 읽기전용 리스트를 조작하려고 하면 에러가 발생한다.")
    @Test
    void getRacingRoundResultsManipulateFailTest() {
        RacingResult racingResult = new RacingResult();
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(List.of(
                setCar("pobi", 3),
                setCar("woni", 3)
        ));
        racingResult.addResult(racingRoundResult);
        List<RacingRoundResult> racingRoundResults = racingResult.getRacingRoundResults();
        assertThatCode(
                () -> racingRoundResults.add(
                        RacingRoundResult.getRacingRoundResult(List.of(setCar("pobi", 4), setCar("woni", 4)))))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatCode(() -> racingRoundResults.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatCode(() -> racingRoundResults.clear())
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("getRacingRoundResult()를 통해 얻어낸 읽기전용 리스트를 조작하려고 하면 에러가 발생한다.")
    @Test
    void getRacingRoundResultsReadSuccessTest() {
        RacingResult racingResult = new RacingResult();
        RacingRoundResult racingRoundResult = RacingRoundResult.getRacingRoundResult(List.of(
                setCar("pobi", 3),
                setCar("woni", 3)
        ));
        racingResult.addResult(racingRoundResult);
        List<RacingRoundResult> racingRoundResults = racingResult.getRacingRoundResults();
        assertThatCode(() -> racingRoundResults.get(0))
                .doesNotThrowAnyException();
    }

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
                        RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        ))
                ), List.of("pobi", "woni")),
                arguments(List.of(
                        RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 3),
                                setCar("woni", 2),
                                setCar("jun", 0)
                        ))
                ), List.of("pobi")),
                arguments(List.of(
                        RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 1),
                                setCar("woni", 1),
                                setCar("jun", 0)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 1)
                        )), RacingRoundResult.getRacingRoundResult(List.of(
                                setCar("pobi", 2),
                                setCar("woni", 2),
                                setCar("jun", 2)
                        ))
                ), List.of("pobi", "woni", "jun"))
        );
    }

    private static Car setCar(String carName, int position) {
        return new Car(new CarName(carName), new FixedCarEngine(true), new Position(position));
    }
}
