package racingcar.model;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RacingGameTest {

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 움직이지 않은 경우 경주 이동한 거리는 0이다.")
    void isAllCarsStopped_Then_ZeroScoreReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(() -> 0);

        // when
        racingGame.play(Cars.withNames(names), 1);

        // then
        String[] carNames = names.split(",");
        List<RoundResult> roundResults = racingGame.getRoundResults();
        RoundResult findRound = Collections.max(roundResults, comparing(RoundResult::getRound));
        List<RaceScore> finalRoundScores = findRound.getResults();

        for (int i = 0; i < finalRoundScores.size(); i++) {
            assertThat(finalRoundScores.get(i).name()).isEqualTo(carNames[i]);
            assertThat(finalRoundScores.get(i).score()).isEqualTo(0);
        }
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 거리는 1이다.")
    void isAllCarsMoveForward_Then_OneScoreReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(() -> 4);

        // when
        racingGame.play(Cars.withNames(names), 1);

        // then
        String[] carNames = names.split(",");
        List<RoundResult> roundResults = racingGame.getRoundResults();
        RoundResult findRound = Collections.max(roundResults, comparing(RoundResult::getRound));
        List<RaceScore> finalRoundScores = findRound.getResults();

        for (int i = 0; i < finalRoundScores.size(); i++) {
            assertThat(finalRoundScores.get(i).name()).isEqualTo(carNames[i]);
            assertThat(finalRoundScores.get(i).score()).isEqualTo(1);
        }
    }

    @ParameterizedTest
    @MethodSource("generateCarNames")
    @DisplayName("모든 자동차가 동일한 속도로 경주한 경우 모두 우승자이다.")
    void isAllCarsMoveForward_Then_AllWinnersReturns(final String names) {
        // given
        RacingGame racingGame = new RacingGame(() -> 4);

        // when
        racingGame.play(Cars.withNames(names), 1);
        Winners winners = Winners.from(racingGame.getHighScores());
        List<String> winnerNames = winners.getNames();

        // then
        assertThat(winnerNames.size()).isEqualTo(3);
        String[] carNames = names.split(",");
        assertThat(winnerNames).containsExactly(carNames);
    }

    private static Stream<Arguments> generateCarNames() {
        return Stream.of(
                Arguments.of("pobi,woni,jun"),
                Arguments.of("pribi,lsh,woni")
        );
    }
}
