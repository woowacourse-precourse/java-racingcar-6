package racingcar.domain;

import racingcar.application.NumberConstraints;

public enum MoveAction {
    GO,
    STOP;

    public static MoveAction of(int number) {
        if (number >= NumberConstraints.MINIMUM_MOVABLE_NUMBER.getValue()) {
            return GO;
        }
        return STOP;
    }
}
