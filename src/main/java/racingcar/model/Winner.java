package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private final List<Car> cars;

    private Winner(List<Car> cars) {
        this.cars = cars;
    }

    public static Winner createWinner(List<Car> cars) {
        return new Winner(cars);
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
