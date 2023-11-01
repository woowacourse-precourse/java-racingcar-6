package racingcar.domain;

import java.util.Objects;

public class Car {

    private String name;
    private int count;

    public Car(String name) {
        this.name = name;
        count = 0;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Car other = (Car) object;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
