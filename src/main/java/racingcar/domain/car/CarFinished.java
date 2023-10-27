package racingcar.domain.car;

import racingcar.domain.car.boxed.CarName;
import racingcar.domain.move.Coordinate;

public final class CarFinished extends Car {

    public CarFinished(
            final CarName carName,
            final Coordinate coordinate
    ) {
        super(carName, coordinate);
    }

    public CarName carName() {
        return carName;
    }

    public Coordinate coordinate() {
        return coordinate;
    }
}
