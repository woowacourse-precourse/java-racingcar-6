package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameScoreTest {
    private Map<RacingCar, String> participants;

    private GameScore createSingleWinner(RacingCar winner, String score) {
        participants.put(winner, score);
        return new GameScore(participants);
    }

    private GameScore createMultipleWinner(List<RacingCar> winners, String score) {
        for (RacingCar winner : winners) {
            participants.put(winner, score);
        }
        return new GameScore(participants);
    }

    @BeforeEach
    void setUp() {
        participants = new LinkedHashMap<>() {{
            put(new RacingCar("pobi"), CarStatus.STOP.getOutput());
            put(new RacingCar("woni"), CarStatus.STOP.getOutput());
            put(new RacingCar("jun"), CarStatus.STOP.getOutput());
        }};
    }

    @DisplayName("자동차 별 점수를 초기화 할 수 있다")
    @Test
    void init(){
        GameScore gameScore = new GameScore(participants);
        String expected = "pobi : \n" + "woni : \n" + "jun : \n";
        assertThat(gameScore.toString()).isEqualTo(expected);
    }


    @DisplayName("자동차 경주 게임의 자동차 별 점수를 최신화 할 수 있다.")
    @ParameterizedTest
    @MethodSource("updatedData")
    void update(RacingCar racingCar, String output) {
        GameScore gameScore = new GameScore(participants);
        gameScore.update(racingCar, () -> Randoms.pickNumberInRange(4, 9));
        assertThat(gameScore.toString()).isEqualTo(output);
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

    static Stream<Arguments> updatedData() {
        return Stream.of(
                arguments(new RacingCar("pobi"), "pobi : -\n" + "woni : \n" + "jun : \n"),
                arguments(new RacingCar("woni"), "pobi : \n" + "woni : -\n" + "jun : \n"),
                arguments(new RacingCar("jun"), "pobi : \n" + "woni : \n" + "jun : -\n")
        );
    }

    static Stream<Arguments> winnerData() {
        return Stream.of(
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("woni"))),
                arguments("--", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"))),
                arguments("---", Arrays.asList(new RacingCar("pobi"), new RacingCar("jun"), new RacingCar("woni")))
        );
    }
}