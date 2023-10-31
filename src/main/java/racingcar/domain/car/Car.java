package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.boxed.CarName;
import racingcar.domain.coordinate.boxed.Coordinate;

public abstract class Car {
    protected final CarName carName;
    protected final Coordinate coordinate;

    protected Car(
            final CarName carName,
            final Coordinate coordinate
    ) {
        this.carName = carName;
        this.coordinate = coordinate;
    }

    protected Car(final String carName) {
        this(new CarName(carName), Coordinate.zero());
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
