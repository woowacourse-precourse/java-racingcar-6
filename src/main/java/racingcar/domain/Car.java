package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String EMPTY_SPACE = "";
    private static final String FORWARD_MOVEMENT_INDICATOR = "-";
    private static final String SEPARATOR = " : ";

    private final Name name;
    private String location;

    public Car(Name name) {
        this.name = name;
        location = EMPTY_SPACE;
    }

    private Car(Name name, String location) {
        this.name = name;
        this.location = location;
    }

    public Car move(int randomNumber) {
        if (isForward(randomNumber)) {
            location += FORWARD_MOVEMENT_INDICATOR;
        }
        return new Car(name, location);
    }

    public int getLocationLength() {
        return location.length();
    }

    public String getName() {
        return name.getName();
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
        return Objects.hash(name, location);
    }

    @Override
    public String toString() {
        return getName() + SEPARATOR + location;
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }
}
