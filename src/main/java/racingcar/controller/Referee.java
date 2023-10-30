package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.RandomNumber;

public class Referee {
    private final List<Car> cars;

    private Referee(List<Car> cars) {
        this.cars = cars;
    }

    public static Referee of(List<Car> cars) {
        return new Referee(cars);
    }

    public void proceedRound() {
        for (Car c: cars) {
            decideMoveForward(c);
        }
    }

    private void decideMoveForward(Car car) {
        RandomNumber randomNumber = RandomNumber.generate();
        if (randomNumber.isEqualOrGreaterThanFour()) {
            car.moveForward();
        }
    }

    public List<Car> determineWinner() {
        List<Car> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(cars);
        for (Car c: cars) {
            if (c.isWinner(winnerPosition)) {
                winners.add(c);
            }
        }
        return winners;
    }

    private int getWinnerPosition(List<Car> cars) {
        List<String> raceResult = new ArrayList<>();
        for (Car c: cars) {
            raceResult.add(c.convertPositionToResult());
        }
        return raceResult.stream()
                .collect(Collectors.summarizingInt(String::length))
                .getMax();
    }
}
