package racingcar.domain;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Car implements Comparable<Car> {
    private final String name;
    private int position;
    private final BooleanSupplier engine;

    public Car(String name, int position, BooleanSupplier engine) {
        this.name = name;
        this.position = position;
        this.engine = engine;
    }

    public void moveForward() {
        if (engine.getAsBoolean()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car car)) {
            return false;
        }
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.position - o.getPosition();
    }
}
