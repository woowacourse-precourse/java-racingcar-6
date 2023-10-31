package racingcar.service;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Progress;

public final class WinnerChecker {

    private static Progress maxProgress;

    public static List<Car> findWinner(List<Car> carList) {
        getMaxProgress(carList);
        return carList.stream()
                .filter(WinnerChecker::isWinner)
                .collect(toList());
    }

    private static void getMaxProgress(List<Car> carList) {
        maxProgress = carList.stream()
                .max(comparingInt(Car::getProgressToInt))
                .map(Car::getProgress)
                .orElseThrow();
    }

    private static boolean isWinner(Car car) {
        return car.getProgressToInt() == maxProgress.get();
    }
}
