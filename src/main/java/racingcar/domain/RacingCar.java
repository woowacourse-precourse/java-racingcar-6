package racingcar.domain;

import racingcar.constant.ProgressMessage;

import java.util.Objects;

public final class RacingCar {

    private final Name name;
    private MoveDistance moveDistance;

    public RacingCar(final Name name) {
        this.name = name;
        this.moveDistance = new MoveDistance();
    }

    public void move() {
        this.moveDistance = moveDistance.next();
    }

    public String toResultMessage() {
        return name.toValue()
                + ProgressMessage.NAME_STATUS_DELIMITER.toValue()
                + moveDistance.toResultMessage();
    }

    public int moveDistance() {
        return moveDistance.toValue();
    }

    public String toName() {
        return name.toValue();
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
