package racingcar.config;

import racingcar.util.GameResultMaker;
import racingcar.controller.RacingGame;

public class RacingGameConfig {

    public RacingGame initRacingGame() {
        GameResultMaker gameResultMaker = new GameResultMaker();
        return new RacingGame(gameResultMaker);
    }
}
