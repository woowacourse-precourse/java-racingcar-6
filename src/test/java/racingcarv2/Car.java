package racingcarv2;

import java.util.Objects;

public class Car {
    private final Name name;
    private int position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public void moveForward() {
        position++;
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
