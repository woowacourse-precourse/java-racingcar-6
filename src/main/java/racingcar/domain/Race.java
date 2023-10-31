package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

import java.util.List;

public class Race {
    private final Cars cars;
    private final MoveStrategy moveStrategy;

    public Race(Cars cars, MoveStrategy moveStrategy) {
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void executeOneRound() {
        cars.moveAll(moveStrategy);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<String> getWinnerNames() {
        return cars.findWinners()
                .stream()
                .map(Car::getName)
                .toList();
    }
}
