package racingcar.utils;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnerFinder {

    public static List<String> findWinners(List<Car> cars) {
        int maxMoveNum = getMaxMoveNum(cars);
        return getWinnerNames(cars, maxMoveNum);
    }

    private static int getMaxMoveNum(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveNum)
                .max()
                .orElse(0);
    }

    private static List<String> getWinnerNames(List<Car> cars, int maxMoveNum) {
        return cars.stream()
                .filter(car -> car.getMoveNum() == maxMoveNum)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
