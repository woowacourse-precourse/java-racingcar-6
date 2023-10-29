package domain;

import java.util.Objects;

public class Car<T> {

    private final ForwardStrategy<T> forwardStrategy;
    private final CarName carName;
    private final CarLocation carLocation;

    private Car(CarName carname, CarLocation carLocation, ForwardStrategy<T> forwardStrategy) {
        this.forwardStrategy = forwardStrategy;
        this.carName = carname;
        this.carLocation = carLocation;
    }

    public void move(T value) {
        if (forwardStrategy.canMove(value)) {
            carLocation.move();
        }
    }

    public static Car<?> of(CarName carName, CarLocation carLocation,
            ForwardStrategy<?> forwardStrategy) {
        return new Car(carName, carLocation, forwardStrategy);
    }

    public CarLocation getCarLocation() {
        return this.carLocation;
    }
    public CarName getCarName(){
        return this.carName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car<?> car = (Car<?>) o;

        return carName.equals(car.carName) && carLocation.equals(car.carLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carLocation);
    }

}
