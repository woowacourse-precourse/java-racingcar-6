package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;
    private final int maxDistance;

    public Winners(List<Car> cars) {
        validateCars(cars);
        maxDistance = calculateMaxDistance(cars);
        winners = findWinningCars(cars, maxDistance);
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public List<String> getWinningCarNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getWinningCars() {
        return winners;
    }

    private int calculateMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private List<Car> findWinningCars(List<Car> cars, int maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private void validateCars(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
