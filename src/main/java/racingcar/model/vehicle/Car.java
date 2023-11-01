package racingcar.model.vehicle;

import racingcar.model.rule.CarMovementStatus;
import racingcar.model.result.RoundResult;

public final class Car {
    private final Name name;
    private final Position position;

    @Override
    public String toString() {
        return name.name();
    }

    private Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car applyName(final Name givenName) {
        return new Car(givenName, new Position(0));
    }

    public Integer changePosition(final CarMovementStatus movementStatus) {
        if (movementStatus.equals(CarMovementStatus.MOVING_FORWARD)) {
            return position.plusOne();
        }
        if (movementStatus.equals(CarMovementStatus.STOP)) {
            return position.getPosition();
        }
        throw new IllegalArgumentException();
    }

    public RoundResult getRoundResult() {
        return new RoundResult(name.name(), position.getPosition());
    }

    public Boolean isWinner(Integer maxPosition) {
        Position givenPosition = new Position(maxPosition);
        return position.isSame(givenPosition);
    }
}
