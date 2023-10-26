package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.game.MoveResult;
import racingcar.domain.move.Coordinate;
import racingcar.domain.move.MoveCommand;

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

    public MoveResult movedBy(final MoveCommand command) {
        if (MoveCommand.GO == command) {
            coordinate.increase();
        }
        return new MoveResult(carName.carName(), coordinate.getCoordinate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(coordinate, car.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, coordinate);
    }
}
