package racingcar.domain.game;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinningResultGenerator {
    private static final String SEPARATOR = ", ";

    public String generateWinners(List<Car> cars) {
        List<String> winningCars = chooseWinningCars(cars);
        return String.join(SEPARATOR, winningCars);
    }

    public List<String> chooseWinningCars(List<Car> cars) {
        Car maxMoveCar = cars.stream()
                .max(Car::compareTo).orElseThrow(()
                        -> new IllegalArgumentException("max 값이 존재하지 않음"));

        return cars.stream()
                .filter(car -> car.isSameAs(maxMoveCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
