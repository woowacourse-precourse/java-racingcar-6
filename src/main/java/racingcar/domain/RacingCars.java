package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.common.strategy.MoveStrategy;

public record RacingCars(List<Car> cars) {
    public RacingCars(List<Car> cars) {
        this.cars = Collections.unmodifiableList(cars);
    }

    public void move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }
}
