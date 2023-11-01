package racingcar.Domain;

import java.util.List;

public class Race {
    private int trialCount;
    private final List<Car> cars;

    public Race(List<Car> cars, int trialCount) {
        this.cars = cars;
        this.trialCount = trialCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTrialCount() {
        return trialCount;
    }

    public void increaseTrialCount() {
        trialCount++;
    }
}
