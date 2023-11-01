package racingcar.domain;

import java.util.List;

public class RacingGame {

    private int attemptNumber;
    private List<Car> cars;
    private int currentAttempt;

    public RacingGame(List<Car> cars, int attemptNumber) {
        this.cars = cars;
        this.attemptNumber = attemptNumber;
        this.currentAttempt = 0;
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void increaseAttempt() {
        currentAttempt++;
    }

    public boolean isEnd() {
        return (attemptNumber == currentAttempt);
    }

}