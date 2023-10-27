package racingcar.domain;

import racingcar.constant.MoveStatus;

public final class RacingCar {

    private static final String NAME_STATUS_DELIMITER = " : ";
    private final Name name;
    private final MoveStatuses moveStatuses;

    public RacingCar(final String name) {
        this.name = new Name(name);
        this.moveStatuses = new MoveStatuses();
    }

    public void addMoveStatus(final MoveStatus moveStatus) {
        moveStatuses.add(moveStatus);
    }

    public String toResultMessage() {
        return name.toValue() + NAME_STATUS_DELIMITER + moveStatuses.toMessage();
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
}
