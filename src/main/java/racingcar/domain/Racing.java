package racingcar.domain;

import java.util.List;
public class Racing {
    private final int trial;
    private final List<Car> cars;
    private int trialNumbers = 0;

    public Racing(List<Car> cars, int trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void increase_trialNumbers() {
        this.trialNumbers += 1;
    }

    public Boolean Check_trial_equals_trialNumbers() {
        return this.trial == this.trialNumbers;
    }
}
