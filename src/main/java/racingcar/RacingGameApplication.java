package racingcar;

import racingcar.domain.car.config.CarConfig;
import racingcar.domain.racinggame.config.RacingGameConfig;
import racingcar.domain.victory.config.VictoryConfig;

public class RacingGameApplication {
    private VictoryConfig cashedVictoryConfig;
    private CarConfig cashedCarConfig;
    private RacingGameConfig cashedRacingGameConfig;

    public static void run() {
        new RacingGameApplication()
                .racingGameConfig()
                .racingGameManager()
                .start();
    }

    private VictoryConfig victoryConfig() {
        if(cashedVictoryConfig == null) {
            cashedVictoryConfig = new VictoryConfig();
        }
        return cashedVictoryConfig;
    }

    private CarConfig carConfig() {
        if(cashedCarConfig == null) {
            cashedCarConfig = new CarConfig(victoryConfig());
        }
        return cashedCarConfig;
    }

    private RacingGameConfig racingGameConfig() {
        if(cashedRacingGameConfig == null) {
            cashedRacingGameConfig = new RacingGameConfig(carConfig());
        }
        return cashedRacingGameConfig;
    }
}
