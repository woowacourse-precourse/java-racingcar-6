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
import racingcar.domain.FixedCarEngine;
import racingcar.domain.RacingResult;

public class RacingCarServiceTest {

    @DisplayName("RacingCarService 객체를 생성한다.")
    @Test
    void createTest() {
        assertThatCode(() -> new RacingCarService(new RacingCarAssemblyService(), new FixedCarEngine(true)))
                .doesNotThrowAnyException();
    }

    @DisplayName("레이싱을 시작해 최종 우승자를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideRaceTestArguments")
    void raceTest(List<String> carNames, int attemptCounts, List<String> expectedWinners) {
        RacingCarService racingCarService = new RacingCarService(new RacingCarAssemblyService(),
                new FixedCarEngine(true));
        RacingResult racingResult = racingCarService.race(carNames, attemptCounts);
        List<String> finalWinners = racingCarService.determineWinner(racingResult);
        assertThat(finalWinners).isEqualTo(expectedWinners);
    }

    static Stream<Arguments> provideRaceTestArguments() {
        return Stream.of(
                arguments(List.of("pobi", "woni", "jun"), 3, List.of("pobi", "woni", "jun")),
                arguments(List.of("pobi", "woni", "jun"), 10, List.of("pobi", "woni", "jun"))
        );
    }
}
