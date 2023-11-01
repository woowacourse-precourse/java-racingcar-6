package racingcar.domain;

import racingcar.domain.Car;
import racingcar.utils.Parser;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private Referee() {
    }

    public static String judgeWinner(List<Car> cars) {
        List<Car> winners = filterWinners(cars);
        List<String> winnerNames = collectWinnerNames(winners);
        return Parser.parseListToString(winnerNames);
    }

    private static List<Car> filterWinners(List<Car> cars) {
        Collections.sort(cars);
        Car winner = cars.get(0);
        return cars.stream()
                .filter(car -> car.compareTraveledDistance(winner))
                .collect(Collectors.toList());
    }

    private static List<String> collectWinnerNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
