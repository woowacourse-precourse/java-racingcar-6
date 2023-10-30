package racingcar.model.race;

import racingcar.model.car.CarManager;
import racingcar.model.cycle.RaceCount;

public class Racing {

    private final CarManager carManager;

    private final RaceCount raceCount;

    public Racing(final String cars, final String raceCount) {
        this(new CarManager(cars), new RaceCount(raceCount));
    }

    public Racing(final CarManager carManager, final RaceCount raceCount) {
        this.carManager = carManager;
        this.raceCount = raceCount;
    }

    public CarManager getCarManager() {
        return carManager;
    }

    public RaceCount getRaceCount() {
        return raceCount;
    }
}
