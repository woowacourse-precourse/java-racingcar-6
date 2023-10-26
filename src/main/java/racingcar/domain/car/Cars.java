package racingcar.domain.car;

import java.util.List;
import racingcar.domain.move.MoveDecider;

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
