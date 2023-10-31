package racingcar.domain;

import java.util.List;

public class Game {

    private final Cars cars;
    private final int givenAttemptCount;
    private int currentAttemptCount = 0;

    public Game(List<Car> cars, int givenAttemptCount) {
        this.cars = new Cars(cars);
        this.givenAttemptCount = givenAttemptCount;
    }

    public void carRaceOnce() {
        cars.move();
        increaseCurrentAttemptCount();
    }

    private void increaseCurrentAttemptCount() {
        currentAttemptCount++;
    }

    public boolean isGameOver() {
        if (currentAttemptCount == givenAttemptCount)
            return true;
        return false;
    }

    public List<String> getWinner() {
        return cars.getWinnerNameList();
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

}
