package racingcar;

import racingcar.domain.victory.VictoryManager;
import racingcar.domain.victory.VictoryView;
import racingcar.domain.car.CarFactory;
import racingcar.domain.car.CarManager;
import racingcar.domain.car.InputCarFactory;
import racingcar.domain.racingGame.RacingGame;
import racingcar.domain.racingGame.RacingGameManager;
import racingcar.domain.racingGame.RacingGameSettingsManager;
import racingcar.domain.racingGame.TryCountManager;

public class RacingGameApplication {
    private RacingGameManager cashedRacingGameManager;
    private RacingGameSettingsManager cashedRacingGameSettingsManager;
    private RacingGame cashedRacingGame;
    private TryCountManager cashedTryCountManager;
    private CarFactory cashedCarFactory;
    private CarManager cashedCarManager;
    private VictoryManager cashedVictoryManager;
    private VictoryView cashedVictoryView;

    public static void run() {
        new RacingGameApplication()
                .racingGameManager()
                .start();
    }

    private TryCountManager tryCountManager() {
        if (cashedTryCountManager == null) {
            cashedTryCountManager = new TryCountManager();
        }
        return cashedTryCountManager;
    }

    private CarFactory carFactory() {
        if (cashedCarFactory == null) {
            cashedCarFactory = new InputCarFactory();
        }
        return cashedCarFactory;
    }

    private VictoryView victoryView() {
        if (cashedVictoryView == null) {
            cashedVictoryView = new VictoryView();
        }
        return cashedVictoryView;
    }

    private VictoryManager victoryManager() {
        if (cashedVictoryManager == null) {
            cashedVictoryManager = new VictoryManager(victoryView());
        }
        return cashedVictoryManager;
    }

    private CarManager carManager() {
        if (cashedCarManager == null) {
            cashedCarManager = new CarManager(carFactory(), victoryManager());
        }
        return cashedCarManager;
    }

    private RacingGameSettingsManager racingGameSettingsManager() {
        if (cashedRacingGameSettingsManager == null) {
            cashedRacingGameSettingsManager = new RacingGameSettingsManager(carManager(), tryCountManager());
        }
        return cashedRacingGameSettingsManager;
    }

    private RacingGame racingGame() {
        if (cashedRacingGame == null) {
            cashedRacingGame = new RacingGame(carManager(), tryCountManager());
        }
        return cashedRacingGame;
    }

    private RacingGameManager racingGameManager() {
        if (cashedRacingGameManager == null) {
            cashedRacingGameManager = new RacingGameManager(racingGameSettingsManager(), racingGame());
        }
        return cashedRacingGameManager;
    }
}
