package racingcar;

import java.util.stream.IntStream;

public final class Car {
    private final String name;
    private Integer position;

    @Override
    public String toString() {
        return name +" : ";
    }

    private Car(final String givenName) {
        this.name = givenName;
        this.position = 0;
    }

    public static Car applyName(final String givenName) {
        return new Car(givenName);
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

    public String getRoundResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        IntStream.range(0, position).forEach(i -> sb.append("-"));
        return sb.toString();
    }
}
