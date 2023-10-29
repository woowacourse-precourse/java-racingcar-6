package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private RacingGame racingGame = new RacingGame();

    @Test
    void 자동차등록_입력받은문자열 () {
        String playerInput = "자동차1,자동차2,자동차3";
        racingGame.setCarList(playerInput);

        assertAll(
                () -> assertEquals(racingGame.getCarList().get(0).getName(), "자동차1"),
                () -> assertEquals(racingGame.getCarList().get(1).getName(), "자동차2"),
                () -> assertEquals(racingGame.getCarList().get(2).getName(), "자동차3")
        );
    }

    @Test
    void 경주횟수등록_입력받은문자열 () {
        String playerInput = "100";
        racingGame.setRaceCount(playerInput);

        assertThat(Integer.parseInt(playerInput)).isEqualTo(racingGame.getRaceCount());
    }

    @Test
    void 경주실행횟수_설정된경주횟수 () {
        racingGame.setRaceCount("3");
        racingGame.startRace();

        assertThat(3).isEqualTo(racingGame.getRaceActionCount());
    }
}