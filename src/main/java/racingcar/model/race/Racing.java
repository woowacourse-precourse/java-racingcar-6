package racingcar.model.race;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import racingcar.model.car.Car;
import racingcar.model.car.CarManager;
import racingcar.model.car.Movable;
import racingcar.model.car.RandomMovable;
import racingcar.model.cycle.RaceCount;

public class Racing {

    private final CarManager carManager;

    private final RaceCount raceCount;

    private final Movable strategy;

    public Racing(final String cars, final String raceCount, final Movable strategy) {
        this(new CarManager(cars), new RaceCount(raceCount), strategy);
    }

    public Racing(final CarManager carManager, final RaceCount raceCount, final Movable strategy) {
        this.carManager = carManager;
        this.raceCount = raceCount;
        this.strategy = strategy;
    }

    public void start(final Consumer<List<Car>> printSingleRaceResult) {
        this.raceCount.runActionInLoop(printSingleRaceResult, () -> this.carManager.move(new RandomMovable()));
    }

    public void getWinner(final Consumer<List<Car>> printFinalRaceResult) {
        printFinalRaceResult.accept(this.carManager.getWinner());
    }

    public CarManager getCarManager() {
        return carManager;
    }

    public RaceCount getRaceCount() {
        return raceCount;
    }

    public Movable getStrategy() {
        return strategy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Racing racing = (Racing) o;
        return Objects.equals(carManager, racing.carManager) && Objects.equals(raceCount,
                racing.raceCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carManager, raceCount);
    }

    @Override
    public String toString() {
        return "Racing{" +
                "carManager=" + carManager +
                ", raceCount=" + raceCount +
                '}';
    }
}
