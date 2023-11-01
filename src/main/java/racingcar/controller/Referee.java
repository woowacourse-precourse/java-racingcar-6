package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
        for (Car c : cars) {
            decideMoveForward(c);
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

        return raceResult.stream()
                .collect(Collectors.summarizingInt(String::length))
                .getMax();
    }

    private void compareCarToWinnerPosition(List<Car> winners, Car car, int winnerPosition) {
        if (car.isEqual(winnerPosition)) {
            winners.add(car);
        }
    }
}
