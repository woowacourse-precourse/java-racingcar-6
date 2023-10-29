package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int FORWARD_BASE_NUMBER = 4;
    private static final String EMPTY_SPACE = "";
    private static final String FORWARD_MOVEMENT_INDICATOR = "-";
    private static final String SEPARATOR = " : ";

    private final Name name;
    private String location = EMPTY_SPACE;

    public Car(Name name) {
        this.name = name;
    }

    public String move(int randomNumber) {
        if (isForward(randomNumber)) {
            location += FORWARD_MOVEMENT_INDICATOR;
        }
        return getName() + SEPARATOR + location;
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
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private boolean isForward(int randomNumber) {
        return randomNumber >= FORWARD_BASE_NUMBER;
    }
}
