package racingcar;

import java.util.List;

public class WinnerFinder {

    public static int getMaxMoveNum(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveNum)
                .max()
                .orElse(0);
    }
}
