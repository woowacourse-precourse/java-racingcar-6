package racingcar.domain.racinggame.config;

import racingcar.domain.car.config.CarConfig;
import racingcar.domain.racinggame.trycountfactory.InputTryCountFactory;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.racinggame.RacingGameManager;
import racingcar.domain.racinggame.RacingGameSettingsManager;
import racingcar.domain.racinggame.TryCountManager;
import racingcar.domain.racinggame.validator.TryCountValidator;

public class RacingGameConfig {
    private RacingGameManager cashedRacingGameManager;
    private RacingGameSettingsManager cashedRacingGameSettingsManager;
    private RacingGame cashedRacingGame;
    private TryCountManager cashedTryCountManager;
    private final CarConfig carConfig;

    public RacingGameConfig(CarConfig carConfig) {
        this.carConfig = carConfig;
    }

    public TryCountManager tryCountManager() {
        if (cashedTryCountManager == null) {
            cashedTryCountManager = new TryCountManager(new InputTryCountFactory(new TryCountValidator()));
        }
        return cashedTryCountManager;
    }
    public RacingGameSettingsManager racingGameSettingsManager() {
        if (cashedRacingGameSettingsManager == null) {
            cashedRacingGameSettingsManager = new RacingGameSettingsManager(carConfig.carManager(), tryCountManager());
        }
        return cashedRacingGameSettingsManager;
    }

    public RacingGame racingGame() {
        if (cashedRacingGame == null) {
            cashedRacingGame = new RacingGame(carConfig.carManager(), tryCountManager());
        }
        return cashedRacingGame;
    }

    public RacingGameManager racingGameManager() {
        if (cashedRacingGameManager == null) {
            cashedRacingGameManager = new RacingGameManager(racingGameSettingsManager(), racingGame());
        }
        return cashedRacingGameManager;
    }
}
