package racingcar.model;

import java.util.Objects;

public class Car {

    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String SEPARATOR = " : ";

    private final Name name;
    private final Location location;

    public Car(Name name) {
        this.name = name;
        location = new Location();
    }

    private Car(Name name, Location location) {
        this.name = name;
        this.location = location;
    }

    public Car move(int randomNumber) {
        if (isForward(randomNumber)) {
            location.goForward();
        }
        return new Car(name, location);
    }

    public int getLocationLength() {
        return location.getLocationLength();
    }

    public String getName() {
        return name.name();
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
        return Objects.equals(name, car.name) && Objects.equals(location, car.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getName() + SEPARATOR + location;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }
}
