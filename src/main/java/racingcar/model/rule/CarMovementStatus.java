package racingcar.model.rule;

public enum CarMovementStatus implements GameRule {
    MOVING_FORWARD, STOP;

    public static CarMovementStatus getMovementStatusByCheckNumber(final Integer targetNumber) {
        if (targetNumber > MOVING_MIN_CONDITION_VALUE) {
            return MOVING_FORWARD;
        }
        return STOP;
    }
}
