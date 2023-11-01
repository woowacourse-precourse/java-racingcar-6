package racingcar.domain.service;

import racingcar.domain.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final RacingGame instance = new RacingGame();

    private RacingGame() {
    }

    public static RacingGame getInstance() {
        return instance;
    }

    public void moveCars(List<Car> cars) {
        cars.forEach(Car::move);
    }

    public List<Car> determineWinners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}