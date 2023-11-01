package racingcar.controller;

import static racingcar.util.Utils.getLongestLength;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.MovementCondition;

public class Referee {
    private final List<Car> cars;

    private Referee(List<Car> cars) {
        this.cars = cars;
    }

    public static Referee of(List<Car> cars) {
        return new Referee(cars);
    }

    public void proceedRound() {
        for (Car car : cars) {
            decideMoveForward(car);
        }
    }

    private void decideMoveForward(Car car) {
        MovementCondition movementCondition = MovementCondition.generate();
        if (movementCondition.isMovable()) {
            car.moveForward();
        }
    }

    public List<Car> determineWinner() {
        List<Car> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(cars);

        for (Car car : cars) {
            compareCarToWinnerPosition(winners, car, winnerPosition);
        }
        return winners;
    }

    private int getWinnerPosition(List<Car> cars) {
        List<String> raceResult = new ArrayList<>();

        for (Car car : cars) {
            raceResult.add(car.convertPositionToString());
        }
        return getLongestLength(raceResult);
    }

    private void compareCarToWinnerPosition(List<Car> winners, Car car, int winnerPosition) {
        if (car.isEqual(winnerPosition)) {
            winners.add(car);
        }
    }
}
