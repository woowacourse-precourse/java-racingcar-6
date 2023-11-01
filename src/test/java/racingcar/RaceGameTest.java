package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.controller.GameController;
import racingcar.model.RaceGame;

public class RaceGameTest {
    RaceGame raceGame = new RaceGame();
    GameController gameController = new GameController();

    @Test
    void 공백_제거하여_자동차_입력_이름_저장하는지_확인() {

        String inputCarName = "pobi. woni,jun  ";
        raceGame.setInputCarName(inputCarName);

        String result = raceGame.getInputCarName();
        String expect = "pobi.woni,jun";

        assertEquals(result, expect);
    }

    @Test
    void 쉼표_기준으로_자동차_이름_분류하는지_확인() {

        String InputCarName = "pobi.,woni, jun*,nila, lala";
        raceGame.setInputCarName(InputCarName);

        gameController.saveCarNames(raceGame);
        List<String> resultCarName = raceGame.getCarNames();

        assertThat(resultCarName).contains("pobi.", "woni", "jun*", "nila", "lala");
    }

}
