package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.common.strategy.MoveStrategy;

public final class RacingCars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    private RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = Collections.unmodifiableList(cars);
        this.moveStrategy = moveStrategy;
    }

    public static RacingCars of(List<Car> carList, MoveStrategy moveStrategy) {
        return new RacingCars(carList, moveStrategy);
    }

    public void move() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> cars() {
        return cars;
    }
}
