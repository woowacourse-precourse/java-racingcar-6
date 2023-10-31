package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners;

    public Winner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}