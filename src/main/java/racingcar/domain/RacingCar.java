package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.ProgressMessage;

import java.util.Objects;

public final class RacingCar {

    private final Name name;
    private MoveDistance moveDistance;

    public RacingCar(final String name) {
        this.name = new Name(name);
        this.moveDistance = new MoveDistance();
    }

    public void move() {
        validateMoveDistance();
        this.moveDistance = moveDistance.next();
    }

    private void validateMoveDistance() {
        if (moveDistance == null) {
            throw new IllegalStateException(ErrorMessage.NOT_INITIALIZED.toValue());
        }
    }

    public String toResultMessage() {
        return name.toValue()
                + ProgressMessage.NAME_STATUS_DELIMITER.toValue()
                + moveDistance.toResultMessage();
    }

    public int moveDistance() {
        validateMoveDistance();
        return moveDistance.toValue();
    }

    public Name toName() {
        return this.name;
    }

    public boolean hasSameDistance(final Integer distance) {
        return moveDistance() == distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
