package domain;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = Position.ZERO;
    }

    public void moveCar(RandomNumberStrategy moveStrategy) {
        if (moveStrategy.isMoveforward()) {
            position = position.moveForward();
        }
    }

    public boolean isSamePosition(int maxPosition) {
        return getPosition() == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car compareCar = (Car)o;
        return this.name.equals(compareCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
