package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import racingcar.model.RaceGame;

public class RaceGameTest {
    RaceGame raceGame = new RaceGame();

    @Test
    void 공백_제거하여_자동차_입력_이름_저장하는지_확인() {

        String inputCarName = "pobi. woni,jun  ";
        raceGame.setInputCarName(inputCarName);

        String result = raceGame.getInputCarName();
        String expect = "pobi.woni,jun";

        assertEquals(result, expect);
    }
}
