package racingcar.domain;

import java.util.List;

public class Game {
    private final List<Car> cars;
    private final int trial;
    private int trialNumber = 0;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseTrialNumber() {
        trialNumber += 1;
    }

    public boolean checkTrialEnd() {
        return this.trial == this.trialNumber;
    }
}
