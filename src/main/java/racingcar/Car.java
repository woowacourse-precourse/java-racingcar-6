package racingcar;

import java.util.Objects;

public class Car {
    private static final String DISTANCE_ICON = "-";
    private static final int MOVING_FORWARD_VALUE = 4;

    private final CarName name;
    private int distance;

    Car(String name) {
        this.name = new CarName(name);
    }

    public void go(RandomNumber randomNumber) {
        if (randomNumber.getNumber() >= MOVING_FORWARD_VALUE) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name.toString();
    }

    @Override
    public String toString() {
        return name + " : " + DISTANCE_ICON.repeat(distance);
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
        return Objects.hash(name, distance);
    }
}
