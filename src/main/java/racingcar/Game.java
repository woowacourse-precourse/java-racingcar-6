package racingcar;

import java.util.List;

public class Game {

    private List<Car> cars;
    private int attemptCount;
    private int currentRound;

    public Game(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.currentRound = 0;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void playOneRound() {
        moveAllCarsOnce();
        increaseRound();
    }

    public void moveAllCarsOnce() {
        for (Car car : cars) {
            car.move();
        }
    }

    public void increaseRound() {
        currentRound++;
    }
}
