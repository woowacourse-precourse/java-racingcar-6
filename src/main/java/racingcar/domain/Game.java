package racingcar.domain;

import java.util.List;

public class Game {
    private final int trial;
    private final List<Car> cars;
    private int trialNumber = 0;

    public Game(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increaseTrialNumber() {
        this.trialNumber += 1;
    }

    public Boolean checkReachTrialNumberToTrial() {
        return this.trial == this.trialNumber;
    }
}
