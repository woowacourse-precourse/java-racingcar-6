package racingcar.model;

public enum CarMovementStatus {
    MOVING_FORWARD , STOP;
    private static final int MOVING_MIN_CONDITION_VALUE = 3;

    public static CarMovementStatus getMovementStatusByCheckNumber(final Integer targetNumber) {
        if(targetNumber > MOVING_MIN_CONDITION_VALUE) return MOVING_FORWARD ;
        return STOP;
    }
}
