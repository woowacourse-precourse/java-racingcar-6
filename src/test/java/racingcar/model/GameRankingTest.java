package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameRankingTest {
    private static Map<RacingCar, String> participants;

    @BeforeAll
    static void setUp() {
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
        RacingCar racingCar = new RacingCar(name);
        GameRanking gameRanking = new GameRanking(participants);
        Map<RacingCar, String> result = gameRanking.progressRound();
        Assertions.assertAll(
                () -> assertThat(result.containsKey(racingCar)).isTrue(),
                () -> assertThat(result.get(racingCar)).isEqualTo(participants.get(racingCar))
        );

    }

}