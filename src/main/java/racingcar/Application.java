package racingcar;

import racingcar.common.config.RacingCarConfig;
import racingcar.game.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        RacingCarConfig racingCarConfig = new RacingCarConfig();
        RacingGameManager racingGameManager = racingCarConfig.getRacingGameManager();
        try {
            racingGameManager.run();
        } finally {
            racingCarConfig.close();
        }
    }
}
