package racingcar.service;

import static java.util.Comparator.comparingInt;

import java.util.List;
import racingcar.domain.Car;

public class WinnerChecker {

    public static List<Car> findWinner(List<Car> carList) {
        return carList.stream()
                .max(comparingInt(Car::getProgressToInt))
                .stream()
                .toList();
    }
}
