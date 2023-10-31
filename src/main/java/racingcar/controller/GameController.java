package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.io.Input;

public class GameController {
    private RacingGame racingGame;

    public void initGame() {
        List<String> names = Input.carNames();
        int finalRound = Input.gameRound();
        this.racingGame = new RacingGame(finalRound, names);
    }


}
