package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class RacingGame {

    private final Cars cars;
    private final int maxProgressCount;
    private int currentProgressCount;

    public static RacingGame createRacingGame(
            Cars cars, int maxProgressCount) {
        return new RacingGame(cars, maxProgressCount);
    }

    private RacingGame(Cars cars,
            int maxProgressCount) {
        this.cars = cars;
        this.currentProgressCount = 0;
        this.maxProgressCount = maxProgressCount;
    }

    public void progress() {
        cars.move();
        increaseProgressCount();
    }

    private void increaseProgressCount() {
        currentProgressCount++;
    }

    public List<Car> getWinner() {
        return cars.getWinner();
    }

    public boolean isRun() {
        return this.currentProgressCount < maxProgressCount;
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public int getCurrentProgressCount() {
        return currentProgressCount;
    }
}
