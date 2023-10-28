package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {

    public static int getMaxMoveNum(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveNum)
                .max()
                .orElse(0);
    }

    public static List<String> getWinnerNames(List<Car> cars, int maxMoveNum) {
        return cars.stream()
                .filter(car -> car.getMoveNum() == maxMoveNum)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
