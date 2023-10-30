package racingcar.domain;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarRoundTest {

    @Order(3)
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "100"})
    void 라운드_생성_테스트(String round) {
        RacingCarRound racingCarRound = new RacingCarRound(round);

        assertThat(racingCarRound).isNotNull();
    }

    @Test
    void 라운드_종료_테스트() {
        String round = "5";

        RacingCarRound racingCarRound = new RacingCarRound(round);

        racingCarRound.roundStart();

        assertThat(racingCarRound.getRound()).isEqualTo(4);
    }

    @Test
    void 게임_종료_테스트() {
        String round = "1";

        RacingCarRound racingCarRound = new RacingCarRound(round);

        racingCarRound.roundStart();

        assertThat(racingCarRound.gameCheck()).isFalse();
    }
}