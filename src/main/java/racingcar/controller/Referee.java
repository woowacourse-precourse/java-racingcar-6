package racingcar.controller;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
