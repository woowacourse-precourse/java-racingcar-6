package racingcar.model.race;

import java.util.List;
import java.util.function.Consumer;
import racingcar.model.car.Car;
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

    public void start(final Consumer<List<Car>> printSingleRaceResult) {
        this.raceCount.runActionInLoop(printSingleRaceResult, this.carManager::move);
    }

    public CarManager getCarManager() {
        return carManager;
    }

    public RaceCount getRaceCount() {
        return raceCount;
    }
}
