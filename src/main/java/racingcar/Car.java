package racingcar;

public final class Car {
    private final String name;
    private Integer position;

    private Car(final String givenName) {
        this.name = givenName;
        this.position = 0;
    }

    public static Car applyName(final String givenName) {
        return new Car(givenName);
    }

    @Override
    public String toString() {
        return name;
    }

    public Integer changePosition(final CarMovementStatus movementStatus) {
        if (movementStatus.equals(CarMovementStatus.MOVE_FORWARD)) {
            return ++position;
        }
        if (movementStatus.equals(CarMovementStatus.STOP)) {
            return position;
        }
        throw new IllegalArgumentException();
    }
}
