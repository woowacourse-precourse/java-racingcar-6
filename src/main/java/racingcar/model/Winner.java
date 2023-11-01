package racingcar.model;

import static racingcar.util.Constants.ZERO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> winners;

    public Winner(List<Car> cars) {
        int maxPosition = calculateMaxPosition(cars);
        this.winners = filterWinners(cars, maxPosition);
    }

    private int calculateMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(ZERO);
    }

    private List<Car> filterWinners(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.isPositionEqualOrGreater(maxPosition))
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}