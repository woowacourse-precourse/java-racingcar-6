package racingcar.model;

public enum CarMovementStatus {
    MOVING_FORWARD , STOP;
    public static CarMovementStatus getMovementStatusByCheckNumber(final Integer targetNumber) {
        if(targetNumber > 3) return MOVING_FORWARD ;
        return STOP;
    }
}
