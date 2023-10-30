package racingcar.domain.result;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RacingGameStatisticsTest {

    @DisplayName("가장 멀리간 자동차를 우승자로 선별한다.")
    @MethodSource("getRacingCarResultsAndWinners")
    @ParameterizedTest(name = "결과 : {0}, 우승자 : {1}")
    void getWinners(RacingGameStatistics racingGameStatistics, List<String> answerWinners) {
        List<String> winners = racingGameStatistics.getWinners();

        Assertions.assertThat(winners).isEqualTo(answerWinners);
    }

    static Stream<Arguments> getRacingCarResultsAndWinners() {
        return Stream.of(getOneWinnerResultsAndWinners(), getDuplicateWinnersResultsAndWinners());
    }

    static Arguments getOneWinnerResultsAndWinners() {
        List<RacingCarResult> results = Arrays.asList(new RacingCarResult("one", 3),
                new RacingCarResult("two", 4), new RacingCarResult("three", 3));
        RacingGameStatistics racingGameStatistics = new RacingGameStatistics(results);
        List<String> winners = List.of("two");
        return Arguments.arguments(racingGameStatistics, winners);
    }

    static Arguments getDuplicateWinnersResultsAndWinners() {
        List<RacingCarResult> results = Arrays.asList(new RacingCarResult("one", 3),
                new RacingCarResult("two", 2), new RacingCarResult("three", 3));
        RacingGameStatistics racingGameStatistics = new RacingGameStatistics(results);
        List<String> winners = List.of("one", "three");
        return Arguments.arguments(racingGameStatistics, winners);
    }

}
