package racingcar;

import java.util.Objects;

public class Car {
    private final Integer INITIAL_POSITION = 0;
    private final String name;
    private Integer position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
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
}
