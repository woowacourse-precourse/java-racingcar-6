package racingcar;

import racingcar.config.RacingGameConfig;
import racingcar.controller.RacingGame;

public class Application {
    public static void main(String[] args) {
        RacingGameConfig gameConfig = new RacingGameConfig();
        RacingGame racingGame = gameConfig.initRacingGame();
        racingGame.start();
    }
}
