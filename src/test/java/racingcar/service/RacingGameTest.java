package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RacingGameTest {

    private RacingGame racingGame = new RacingGame();

    @Test
    void 자동차등록_입력받은문자열() {
        String playerInput = "자동차1,자동차2,자동차3";
        racingGame.setCarList(playerInput);

        assertAll(
                () -> assertEquals(racingGame.getCarList().get(0).getName(), "자동차1"),
                () -> assertEquals(racingGame.getCarList().get(1).getName(), "자동차2"),
                () -> assertEquals(racingGame.getCarList().get(2).getName(), "자동차3")
        );
    }

    @Test
    void 경주횟수등록_입력받은문자열() {
        String playerInput = "100";
        racingGame.setNumberOfRaces(playerInput);

        assertThat(Integer.parseInt(playerInput)).isEqualTo(racingGame.getNumberOfRaces());
    }

    @Test
    void 경주실행횟수_설정된경주횟수() {
        racingGame.setNumberOfRaces("3");
        racingGame.startRace();

        assertThat(3).isEqualTo(racingGame.getNumberOfRaceRuns());
    }

    @Test
    void 우승자선정_가장많이움직인자동차_하나의우승자() {
        String playerInput = "자동차1,자동차2,자동차3";
        racingGame.setCarList(playerInput);

        racingGame.getCarList().get(0).setPosition(3);
        racingGame.getCarList().get(1).setPosition(3);
        racingGame.getCarList().get(2).setPosition(4);

        racingGame.setWinnerList();

        assertThat("자동차3").isEqualTo(racingGame.getWinnerList().get(0));
    }

    @Test
    void 우승자선정_가장많이움직인자동차_여러우승자() {
        String playerInput = "자동차1,자동차2,자동차3";
        racingGame.setCarList(playerInput);

        racingGame.getCarList().get(0).setPosition(3);
        racingGame.getCarList().get(1).setPosition(4);
        racingGame.getCarList().get(2).setPosition(4);

        racingGame.setWinnerList();

        assertAll(
                () -> assertEquals(racingGame.getWinnerList().size(), 2),
                () -> assertTrue(racingGame.getWinnerList().contains("자동차2")),
                () -> assertTrue(racingGame.getWinnerList().contains("자동차3"))
        );
    }
}