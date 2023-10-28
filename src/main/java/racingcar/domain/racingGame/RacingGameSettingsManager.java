package racingcar.domain.racingGame;

import racingcar.domain.car.CarManager;

public class RacingGameSettingsManager {
    private final CarManager carManager;
    private final TryCountManager tryCountManager;

    public RacingGameSettingsManager(CarManager carManager, TryCountManager tryCountManager) {
        this.carManager = carManager;
        this.tryCountManager = tryCountManager;
    }

    public void setting() {
        carManager.makeCar();
        tryCountManager.makeTryCount();
    }
}
