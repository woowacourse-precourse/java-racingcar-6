package racingcar.model.domain;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int trial;
    private int count = 0;

    private Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public static Game of(List<Car> cars, int trial) {
        return new Game(cars, trial);
    }

    public void increaseCount() {
        count += 1;
    }

    public boolean isFinished() {
        return trial == count;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrial() {
        return trial;
    }
}