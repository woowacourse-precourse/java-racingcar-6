package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.constant.MoveStatus;

public final class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final List<MoveStatus> moveStatuses;

    public RacingCar(final String name) {
        validate(name);
        this.name = name;
        this.moveStatuses = new ArrayList<>();
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.toValue());
        }
    }

    public void addMoveStatusIfMove(final MoveStatus moveStatus) {
        if (moveStatus.isMove()) {
            moveStatuses.add(moveStatus);
        }
    }
}
