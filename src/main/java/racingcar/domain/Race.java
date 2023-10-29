package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public Race(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void executeOneRound() {
        cars.stream()
                .filter(car -> moveStrategy.isAbleToMove())
                .forEach(Car::move);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
