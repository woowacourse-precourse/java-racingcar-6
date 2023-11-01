package racingcar;

import racingcar.game.io.RacingGameBridge;
import racingcar.game.io.RacingGameResponder;

public class Application {
    public static void main(String[] args) {
        RacingGameBridge racingGameBridge = new RacingGameBridge();
        racingGameBridge.initializeGame();
        racingGameBridge.runGame();
    }
}
