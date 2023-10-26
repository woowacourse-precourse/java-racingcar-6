package racingcar.domain;

public class Car {
    private static final int MOVE_THRESHOLD = 4;

    private final CarName name;
    private Position position;

    public Car(final String name) {
        this.name = CarName.from(name);
        this.position = Position.init();
    }

    public void moveForward(final int fuel) {
        if (canMove(fuel)) {
            this.position = position.moveForward();
        }
    }

    private static boolean canMove(final int fuel) {
        return fuel >= MOVE_THRESHOLD;
    }

    public boolean isSamePosition(final Position compare) {
        return position.equals(compare);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        final Car other = (Car) object;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
