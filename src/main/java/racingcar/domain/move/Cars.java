package racingcar.domain.move;

import java.util.List;

public final class Cars {
    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<Car> cars) {
        return new Cars(cars);
    }

    public void moveAllBy(final MoveDecider moveDecider) {
        // TODO:
    }
}
