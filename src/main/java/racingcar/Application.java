package racingcar;

import racingcar.common.config.RacingCarConfig;
import racingcar.game.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        RacingGameManager racingGameManager = new RacingCarConfig().getRacingGameManager();

        racingGameManager.run();
    }
}
