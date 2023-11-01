package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    public String determineWinners(List<Car> cars) {
        int maxProgress = getMaxProgress(cars);
        return cars.stream()
                .filter(car -> car.getProgressCount() == maxProgress)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private static int getMaxProgress(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (car.getProgressCount() > max) {
                max = car.getProgressCount();
            }
        }
        return max;
    }
}
