package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Number;

public class Referee {
    private List<Car> cars;

    Referee(List<Car> cars) {
        this.cars = cars;
    }
    public void proceedRound() {
        for (Car c: cars) {
            decideMoveForward(c);
        }
    }

    private void decideMoveForward(Car car) {
        Number randomNumber = Number.generateRandomNumber();
        if (randomNumber.isEqualOrGreaterThanFour()) {
            car.moveForward();
        }
    }

    public int determineWinner() {
        return 0;
    }
}
