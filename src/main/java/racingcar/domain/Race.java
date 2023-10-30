package racingcar.domain;

import java.util.List;

public class Race {

    private List<Car> cars;
    private int attemptCount;

    public Race(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        // TODO: 구현 필요
    }

    public List<Car> findWinners() {
        return null;
    }
}
