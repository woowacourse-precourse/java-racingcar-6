package racingcar.service;

import racingcar.domain.AttemptCount;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class GameService {
    private final Cars cars;
    private final AttemptCount attemptCount;

    public GameService(Cars cars) {
        this.cars = cars;
        attemptCount = new AttemptCount();
    }

    public void move() {
        cars.moveForward();
        attemptCount.increaseCount();
    }

    public boolean isNotFinish(int count) {
        return attemptCount.isOver(count);
    }

    public Cars getRecord() {
        return cars;
    }

    public Winners getWinners() {
        return cars.getWinners();
    }
}
