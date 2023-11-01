package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;

    private ProgressCount progressCount;

    public static RacingGame createRacingGame(
            Cars cars, ProgressCount progressCount) {
        return new RacingGame(cars, progressCount);
    }

    private RacingGame(Cars cars,
            ProgressCount progressCount) {
        this.cars = cars;
        this.progressCount = progressCount;
    }

    public void progress() {
        cars.move();
        increaseProgressCount();
    }

    private void increaseProgressCount() {
        progressCount.increase();
    }

    public List<Car> getWinner() {
        return cars.getWinner();
    }

    public boolean isRun() {
        return progressCount.isUnderLimit();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCurrentProgressCount() {
        return progressCount.getCurrentProgressCount();
    }
}
