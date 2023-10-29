package racingcar.domain.racingGame;

import racingcar.domain.car.CarManager;

public class RacingGame {
    private final CarManager carManager;
    private final TryCountManager tryCountManager;

    public RacingGame(CarManager carManager, TryCountManager tryCountManager) {
        this.carManager = carManager;
        this.tryCountManager = tryCountManager;
    }

    public void play() {

        progressGame();

        showVictory();

    }

    private void progressGame() {
        tryCountManager.invokeForTryCount(carManager::moveAndShowProgress);
    }

    private void showVictory() {
        carManager.showVictory();
    }


}
