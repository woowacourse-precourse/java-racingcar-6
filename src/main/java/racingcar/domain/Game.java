package racingcar.domain;

import java.util.List;

public class Game {
    private final int numberOfTrials;
    private final List<Car> cars;
    private int currentTrial = 0;

    public Game(List<Car> cars, int numberOfTrials) {
        this.cars = cars;
        this.numberOfTrials = numberOfTrials;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseCurrentTrial() {
        this.currentTrial += 1;
    }

    public boolean isGameFinished() {
        return this.numberOfTrials == this.currentTrial;
    }
}
