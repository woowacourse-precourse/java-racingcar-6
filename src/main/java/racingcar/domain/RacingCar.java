package racingcar.domain;

import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;

public final class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_STATUS_DELIMITER = " : ";
    private final String name;
    private final MoveStatuses moveStatuses;

    public RacingCar(final String name) {
        validate(name);
        this.name = name;
        this.moveStatuses = new MoveStatuses();
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.toValue());
        }
    }

    public void addMoveStatus(final MoveStatus moveStatus) {
        moveStatuses.add(moveStatus);
    }

    public String toResultMessage() {
        return name + NAME_STATUS_DELIMITER + moveStatuses.toMessage();
    }

    public int moveDistance() {
        return moveStatuses.numOfElement();
    }

    public String toName() {
        return this.name;
    }

    public boolean hasSameDistance(final Integer distance) {
        return moveDistance() == distance;
    }
}
