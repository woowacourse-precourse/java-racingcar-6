package racingcar.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;

public class WinnerChecker {
    public static List<Car> findWinner(List<Car> carList) {
        int maxProgress = getMaxProgress(carList);
        return carList.stream()
                .filter(i -> i.getProgressToInt() == maxProgress)
                .collect(toList());
    }

    private static int getMaxProgress(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getProgressToInt)
                .max()
                .orElseThrow();
    }
}
