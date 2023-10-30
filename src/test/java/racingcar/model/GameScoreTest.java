package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameScoreTest {
    private Map<RacingCar, String> participants;

    @BeforeEach
    void setUp() {
        participants = new HashMap() {{
            put(new RacingCar("pobi"), CarStatus.STOP.getOutput());
            put(new RacingCar("woni"), CarStatus.STOP.getOutput());
            put(new RacingCar("jun"), CarStatus.STOP.getOutput());
        }};
    }


    @DisplayName("자동차 경주 게임의 현황을 알 수 있다")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void progressRound(String name) {
        GameScore gameScore = new GameScore(participants);
        Map<RacingCar, String> result = gameScore.progressRound();
        RacingCar racingCar = new RacingCar(name);
        Assertions.assertAll(
                () -> assertThat(result.containsKey(racingCar)).isTrue(),
                () -> assertThat(result.get(racingCar)).isEqualTo(participants.get(racingCar))
        );
    }

    @DisplayName("우승자가 한명인 경우 누가 우승했는지 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"---:pobi", "--:woni", "-:jun"}, delimiter = ':')
    void getWinner(String score, String winner) {
        GameScore gameScore = createSingleWinner(new RacingCar(winner), score);
        List<RacingCar> result = gameScore.getWinner();
        Assertions.assertAll(
                () -> assertThat(result.size()).isEqualTo(1),
                () -> assertThat(result.get(0)).isEqualTo(new RacingCar(winner))
        );
    }

    private GameScore createSingleWinner(RacingCar winner, String score) {
        participants.put(winner, score);
        return new GameScore(participants);
    }

    @DisplayName("우승자가 여러명인 경우 누가 우승했는지 알 수 있다.")
    @ParameterizedTest
    @MethodSource("winnerData")
    void getMultipleWinner(String score, List<RacingCar> winners) {
        GameScore gameScore = createMultipleWinner(winners, score);
        List<RacingCar> result = gameScore.getWinner();
        Assertions.assertAll(
                () -> assertThat(result.size()).isEqualTo(winners.size()),
                () -> assertThat(result).containsAll(winners)
        );
    }

    private GameScore createMultipleWinner(List<RacingCar> winners, String score) {
        for (RacingCar winner : winners) {
            participants.put(winner, score);
        }
        return new GameScore(participants);
    }

    static Stream<Arguments> winnerData() {
        return Stream.of(
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("woni"))),
                arguments("--", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"))),
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"), new RacingCar("woni")))
        );
    }
}