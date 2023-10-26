package racingcar.domain.car;

import racingcar.domain.game.MoveResult;
import racingcar.domain.move.Coordinate;

public class Car {
    private final CarName carName;
    private final Coordinate coordinate;

    private Car(
            final CarName carName,
            final Coordinate coordinate
    ) {
        this.carName = carName;
        this.coordinate = coordinate;
    }

    public Car(final String carName) {
        this(new CarName(carName), Coordinate.zero());
    }

    public MoveResult moved() {
        coordinate.increase();
        return new MoveResult(carName.carName(), coordinate.getCoordinate());
    }

}
