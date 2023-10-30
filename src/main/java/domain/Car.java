package domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final CarLocation carLocation;

    private Car(CarName carname, CarLocation carLocation) {
        this.carName = carname;
        this.carLocation = carLocation;
    }

    public void move() {
        carLocation.move();
    }

    public static Car of(CarName carName, CarLocation carLocation) {
        return new Car(carName, carLocation);
    }

    public CarLocation getCarLocation() {
        return this.carLocation;
    }

    public CarName getCarName() {
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

        Car car = (Car) o;

        return carName.equals(car.carName) && carLocation.equals(car.carLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carLocation);
    }

}
