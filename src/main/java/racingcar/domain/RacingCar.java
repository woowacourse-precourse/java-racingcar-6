package racingcar.domain;

import java.util.Objects;
import racingcar.constant.MoveStatus;

public final class RacingCar {

    private static final String NAME_STATUS_DELIMITER = " : ";
    private final Name name;
    private final MoveStatuses moveStatuses;

    public RacingCar(final Name name) {
        this.name = name;
        this.moveStatuses = new MoveStatuses();
    }

    public void addMoveStatus(final MoveStatus moveStatus) {
        moveStatuses.add(moveStatus);
    }

    public String toResultMessage() {
        return name.toValue() + NAME_STATUS_DELIMITER + moveStatuses.toResultMessage();
    }

    public int moveDistance() {
        return moveStatuses.numOfElement();
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
