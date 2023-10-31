package racingcar.domain;

import java.util.Objects;
import java.util.function.IntSupplier;

public class Car implements Comparable<Car> {
    public static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;
    private final IntSupplier intSupplier;

    public Car(String name, int position, IntSupplier intSupplier) {
        this.name = name;
        this.position = position;
        this.intSupplier = intSupplier;
    }

    public void moveForward() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return intSupplier.getAsInt() >= MOVE_THRESHOLD;
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
