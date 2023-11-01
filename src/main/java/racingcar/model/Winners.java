package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(Cars cars) {
        int maxDistance = getMaxDistance(cars);
        this.winners = getFinalWinnerCars(cars, maxDistance);
    }

    public List<String> getFinalWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxDistance(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    public List<Car> getFinalWinnerCars(Cars cars, int maxDistance) {
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxDistance)
                .collect(Collectors.toList());
    }
}
