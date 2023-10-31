package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racingcar.common.strategy.MoveStrategy;

public final class RacingCars {
    private final List<Car> cars;
    private final MoveStrategy moveStrategy;

    public RacingCars(List<Car> cars, MoveStrategy moveStrategy) {
        this.cars = Collections.unmodifiableList(cars);
        this.moveStrategy = moveStrategy;
    }

    public void move() {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<Car> cars() {
        return cars;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (RacingCars) obj;
        return Objects.equals(this.cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "RacingCars[" +
                "cars=" + cars + ']';
    }

}
