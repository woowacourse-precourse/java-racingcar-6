package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = Distance.from(0);
    }

    public void go() {
        distance = distance.add(1);
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
